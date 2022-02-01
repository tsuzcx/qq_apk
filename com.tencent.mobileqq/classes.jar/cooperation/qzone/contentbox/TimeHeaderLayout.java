package cooperation.qzone.contentbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.vip.VipReporterManager;
import mqq.app.AppRuntime;

public class TimeHeaderLayout
  extends LinearLayout
  implements View.OnClickListener
{
  public static String KEY_TIME_CAPSULE_EXPAND = "capsule_open";
  ImageView avatarView;
  Handler handler;
  TimeHeaderLayout.HeadInfo headInfo;
  TextView loginDaysView;
  private Context mContext;
  private LinearLayout mLayoutVisitor;
  TimeHeaderLayout.OnDetailClickListner onDetailClickListner;
  SharedPreferences preferences;
  TextView registerDyasView;
  View timeCapsule;
  TextView vistorView;
  
  public TimeHeaderLayout(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public TimeHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    init();
  }
  
  private String getCurrentUin()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime != null) {
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  private String getVisitorJumpUrl()
  {
    String str2 = QzoneConfig.getInstance().getConfig("H5Url", "QzoneVisitor", "https://h5.qzone.qq.com/qzone/visitor/{hostUin}?uin={uin}&from={from}&qua={qua}&clicktime={clicktime}&hostuin={hostUin}&_wv=3&_proxy=1&trace_detail=%7B%22appid%22%3A%22{refer}%22%7D");
    if (TextUtils.isEmpty(str2)) {
      return str2;
    }
    String str3 = getCurrentUin();
    String str1 = str2;
    if (!TextUtils.isEmpty(str3)) {
      str1 = str2.replace("{uin}", str3).replace("{hostUin}", str3);
    }
    return str1.replace("{clicktime}", System.currentTimeMillis() + "").replace("{from}", "androidQQ").replace("{qua}", QUA.getQUA3());
  }
  
  private void init()
  {
    this.handler = new Handler(Looper.getMainLooper());
    LayoutInflater.from(getContext()).inflate(2131562572, this, true);
    this.preferences = BaseApplicationImpl.getApplication().getSharedPreferences("qzone_time_capsule", 0);
    this.timeCapsule = findViewById(2131379344);
    this.avatarView = ((ImageView)findViewById(2131363196));
    this.registerDyasView = ((TextView)findViewById(2131376283));
    this.loginDaysView = ((TextView)findViewById(2131375775));
    this.vistorView = ((TextView)findViewById(2131376356));
    this.mLayoutVisitor = ((LinearLayout)findViewById(2131370220));
    this.mLayoutVisitor.setOnClickListener(this);
    findViewById(2131379344).setOnClickListener(this);
    VipReporterManager.a(9, 1);
  }
  
  private void onDetailClick(TimeHeaderLayout.HeadInfo paramHeadInfo)
  {
    LpReportInfo_dc02880 localLpReportInfo_dc02880 = new LpReportInfo_dc02880(7, 3);
    LpReportManager.getInstance().reportToDC02880(localLpReportInfo_dc02880, false, true);
    if ((this.onDetailClickListner != null) && (paramHeadInfo != null)) {
      this.onDetailClickListner.onDetailClick(paramHeadInfo.jumpUrl, 2131379344);
    }
  }
  
  private void update()
  {
    Object localObject = FaceDrawable.getDefaultDrawable(1, 3);
    localObject = FaceDrawable.getFaceDrawable(((BaseActivity)this.mContext).app, 1, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 3, (Drawable)localObject, (Drawable)localObject, null);
    this.avatarView.setImageDrawable((Drawable)localObject);
    if (this.headInfo != null)
    {
      if (this.headInfo.todayVisitor <= 999L) {
        break label122;
      }
      this.vistorView.setText("999+");
      if (this.headInfo.loginDays <= 999L) {
        break label142;
      }
      this.loginDaysView.setText("999+");
    }
    for (;;)
    {
      if (this.headInfo.registerDays <= 9999L) {
        break label162;
      }
      this.registerDyasView.setText("9999+");
      return;
      label122:
      this.vistorView.setText(String.valueOf(this.headInfo.todayVisitor));
      break;
      label142:
      this.loginDaysView.setText(String.valueOf(this.headInfo.loginDays));
    }
    label162:
    this.registerDyasView.setText(String.valueOf(this.headInfo.registerDays));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      onDetailClick(this.headInfo);
      continue;
      if (this.onDetailClickListner != null)
      {
        String str = getVisitorJumpUrl();
        if (QLog.isColorLevel()) {
          QLog.i("QZoneMsg", 0, " jump url = " + str);
        }
        VipReporterManager.a(9, 2);
        this.onDetailClickListner.onDetailClick(str, 2131370220);
      }
    }
  }
  
  public void setHeadInfo(TimeHeaderLayout.HeadInfo paramHeadInfo)
  {
    this.headInfo = paramHeadInfo;
    if (paramHeadInfo != null) {
      ThreadManagerV2.executeOnSubThread(new TimeHeaderLayout.1(this));
    }
  }
  
  public void setOnDetailClickListner(TimeHeaderLayout.OnDetailClickListner paramOnDetailClickListner)
  {
    this.onDetailClickListner = paramOnDetailClickListner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.TimeHeaderLayout
 * JD-Core Version:    0.7.0.1
 */