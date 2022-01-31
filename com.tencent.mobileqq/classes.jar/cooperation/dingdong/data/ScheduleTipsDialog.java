package cooperation.dingdong.data;

import amlf;
import amlg;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Vibrator;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.av.utils.DingdongSoundUtil;
import com.tencent.av.utils.PhoneStatusTools;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import java.io.File;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class ScheduleTipsDialog
  extends BaseActivity
  implements View.OnClickListener
{
  private static final long[] jdField_a_of_type_ArrayOfLong = { 100L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L, 1500L };
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected PowerManager.WakeLock a;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ScheduleReminderMgr.onScheduleTipsListener jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener = new amlf(this);
  private String jdField_a_of_type_JavaLangString;
  private LinkedHashMap jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView d;
  private TextView e;
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361926));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363552));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363555));
    this.d = ((TextView)findViewById(2131364037));
    this.e = ((TextView)findViewById(2131364038));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131364324);
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void a(Context paramContext)
  {
    if (b(paramContext))
    {
      paramContext = (Vibrator)paramContext.getSystemService("vibrator");
      if (paramContext != null) {
        paramContext.vibrate(jdField_a_of_type_ArrayOfLong, -1);
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    boolean bool;
    do
    {
      Serializable localSerializable;
      do
      {
        return;
        localSerializable = paramIntent.getSerializableExtra("summaryinfo");
        this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("isforeground", false);
      } while ((localSerializable == null) || (!(localSerializable instanceof DingdongPluginDataFactory.ScheduleSummaryData)));
      paramIntent = (DingdongPluginDataFactory.ScheduleSummaryData)localSerializable;
      bool = paramIntent.hasAlarm;
      a(paramIntent);
    } while (!bool);
    this.jdField_a_of_type_Boolean = true;
    a(this);
    b(this);
  }
  
  private void a(Window paramWindow)
  {
    if (a(this)) {
      paramWindow.addFlags(524288);
    }
    for (;;)
    {
      paramWindow.addFlags(2097152);
      paramWindow.addFlags(256);
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        paramWindow.addFlags(4194304);
      } else {
        paramWindow.addFlags(4718592);
      }
    }
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if (paramTextView == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramTextView.setVisibility(8);
      return;
    }
    paramTextView.setText(paramString);
    paramTextView.setVisibility(0);
  }
  
  private void a(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    String str = paramScheduleSummaryData.id;
    long l1 = paramScheduleSummaryData.beginTime;
    long l2 = paramScheduleSummaryData.offsetTime;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(str, paramScheduleSummaryData);
    str = str + (l1 - l2);
    this.d.setTag(str);
    this.e.setTag(str);
    b(paramScheduleSummaryData);
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  private void b(Context paramContext)
  {
    if (c(paramContext))
    {
      if (!DingdongSoundUtil.a("dingdong_schedule_notify.mp3")) {
        break label54;
      }
      AudioUtil.a(Uri.fromFile(new File(DingdongSoundUtil.a() + "dingdong_schedule_notify.mp3")), 6, null);
    }
    label54:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ScheduleTipsDialog", 2, "startRing not download ");
      }
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramContext != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ScheduleTipsDialog", 2, "tempApp is null ");
    return;
    DingdongSoundUtil.a(paramContext);
  }
  
  private void b(DingdongPluginDataFactory.ScheduleSummaryData paramScheduleSummaryData)
  {
    if (paramScheduleSummaryData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScheduleTipsDialog", 2, "updateNotificationContent is null ");
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramScheduleSummaryData.id;
    if (paramScheduleSummaryData.type == 1)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(2);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(0);
      this.e.setText("查看详情");
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      TroopReportor.a("Grp_edu", "Grp_notice", "NoticeBox_Show", 0, 0, new String[] { String.valueOf(paramScheduleSummaryData.sourceId) });
    }
    for (;;)
    {
      a(this.jdField_a_of_type_AndroidWidgetTextView, paramScheduleSummaryData.title);
      a(this.jdField_c_of_type_AndroidWidgetTextView, paramScheduleSummaryData.location);
      if ((this.jdField_c_of_type_AndroidWidgetTextView == null) || (this.jdField_c_of_type_AndroidWidgetTextView.getText().toString().length() > 0)) {
        break;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
      this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      this.e.setText(2131428074);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      a(this.jdField_b_of_type_AndroidWidgetTextView, DingdongPluginHelper.a(paramScheduleSummaryData.beginTime, paramScheduleSummaryData.endTime, true));
    }
  }
  
  private boolean b(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AudioUtil.a() != 0)
    {
      bool1 = bool2;
      if (!PhoneStatusTools.d(paramContext)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      for (String str = null; localIterator.hasNext(); str = (String)localIterator.next()) {}
      b((DingdongPluginDataFactory.ScheduleSummaryData)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(str));
      return;
    }
    b();
    finish();
  }
  
  private void c(Context paramContext)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext != null) {
      paramContext.cancel();
    }
    AudioUtil.a();
  }
  
  private boolean c(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (AudioUtil.a() != 0)
    {
      bool1 = bool2;
      if (!PhoneStatusTools.a(paramContext))
      {
        bool1 = bool2;
        if (!PhoneStatusTools.c(paramContext))
        {
          bool1 = bool2;
          if (!PhoneStatusTools.d(paramContext)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    DingdongPluginHelper.a("0X800652D", 1);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.putExtra("schedule_feed_id", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("schedule_create_form_reminder_bool", true);
    if (this.jdField_b_of_type_Boolean)
    {
      localIntent.putExtra("schedule_need_update_bool", true);
      DingdongPluginHelper.a(this, "com.dingdong.business.Schedule.Activity.ScheduleDetailActivity", localIntent, -1);
      return;
    }
    localIntent.putExtra("from_url", true);
    localIntent.putExtra("schedule_need_update_bool", false);
    DingdongPluginHelper.a(this, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", localIntent, -1);
  }
  
  @TargetApi(16)
  public boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
        if (QLog.isColorLevel()) {
          QLog.e("ScheduleTipsDialog", 2, "isKeyguardLocked = " + localKeyguardManager.isKeyguardLocked() + ". isKeyguardSecure =" + localKeyguardManager.isKeyguardSecure());
        }
        if ((localKeyguardManager != null) && (localKeyguardManager.isKeyguardLocked()))
        {
          boolean bool = localKeyguardManager.isKeyguardSecure();
          if (bool) {
            return true;
          }
        }
        return false;
      }
      catch (SecurityException localSecurityException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ScheduleTipsDialog", 2, "isKeyguardLocked() = " + localSecurityException);
        }
        return QQUtils.a(paramContext);
      }
    }
    return QQUtils.a(paramContext);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    DingdongPluginHelper.a("0X800652C", 1);
    this.jdField_c_of_type_Boolean = true;
    a(getWindow());
    setContentView(2130968935);
    ((DingdongPluginManager)this.app.getManager(114)).a(this.jdField_a_of_type_CooperationDingdongDataScheduleReminderMgr$onScheduleTipsListener);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new amlg(this);
    super.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)getSystemService("power")).newWakeLock(268435462, "ScheduleTipsDialog");
    this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire(5000L);
    a();
    a(getIntent());
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.jdField_c_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    ((DingdongPluginManager)this.app.getManager(114)).a();
    if (this.jdField_a_of_type_Boolean) {
      c(this);
    }
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    if ((!this.jdField_a_of_type_JavaUtilLinkedHashMap.isEmpty()) && (this.jdField_a_of_type_JavaLangString != null)) {}
    for (DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = (DingdongPluginDataFactory.ScheduleSummaryData)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(this.jdField_a_of_type_JavaLangString);; localScheduleSummaryData = null)
    {
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131364037: 
        if ((localScheduleSummaryData != null) && (localScheduleSummaryData.type == 1)) {
          TroopReportor.a("Grp_edu", "Grp_notice", "NoticeBox_Sure", 0, 0, new String[] { String.valueOf(localScheduleSummaryData.sourceId) });
        }
        for (;;)
        {
          c();
          return;
          DingdongPluginHelper.a("0X800652E", 1);
        }
      }
      if ((localScheduleSummaryData != null) && (localScheduleSummaryData.type == 1))
      {
        TroopReportor.a("Grp_edu", "Grp_notice", "NoticeBox_Detail", 0, 0, new String[] { String.valueOf(localScheduleSummaryData.sourceId) });
        if (localScheduleSummaryData.url != null)
        {
          paramView = new Intent(this, QQBrowserActivity.class);
          paramView.putExtra("url", localScheduleSummaryData.url);
          paramView.putExtra("finish_animation_up_down", true);
          startActivity(paramView);
        }
        for (;;)
        {
          c();
          return;
          d();
        }
      }
      d();
      b();
      finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.dingdong.data.ScheduleTipsDialog
 * JD-Core Version:    0.7.0.1
 */