package cooperation.qzone.contentbox;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import apbo;
import apbx;
import bdll;
import bhtq;
import bmyo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class MsgCardView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = bhtq.b(35.0F);
  private static final int jdField_b_of_type_Int = bhtq.b(12.0F);
  private static final int jdField_c_of_type_Int = bhtq.b(12.0F);
  private static final int jdField_d_of_type_Int = bhtq.b(10.0F);
  private static final int e = bhtq.b(18.0F);
  private static final int f = bhtq.b(230.0F);
  private static final int g = bhtq.b(8.0F);
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bmyo jdField_a_of_type_Bmyo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public QQDailyArkView a;
  private MsgPhotoView jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
  private RoundCornerLinearLayout jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCornerLinearLayout jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private int h = -1;
  
  public MsgCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562471, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378977));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379034));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378979));
    this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout = ((RoundCornerLinearLayout)findViewById(2131371456));
    this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setRadius(g);
    this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout = ((RoundCornerLinearLayout)findViewById(2131371474));
    this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setRadius(g);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131371475));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371464));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371463));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371497));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131371457));
    this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView = ((QQDailyArkView)findViewById(2131362940));
  }
  
  private BaseMsgView a()
  {
    return this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
  }
  
  private void a(long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l < 3600000L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131705833));
      return;
    }
    l /= 3600000L;
    if (l < 24L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format("%d小时前", new Object[] { Long.valueOf(l) }));
      return;
    }
    String str = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(paramLong));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
  
  public LinearLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  public TextView a()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public void a()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.a())) {
      return;
    }
    localBaseMsgView.a();
  }
  
  public boolean a()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.a())) {}
    label95:
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        i = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getMeasuredHeight();
      }
      for (int i = ((LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).topMargin + i;; i = 0)
      {
        if (i + jdField_d_of_type_Int + getTop() < 0) {
          break label95;
        }
        i = ((ListView)getParent()).getMeasuredHeight();
        if (getTop() + getMeasuredHeight() - e > i) {
          break;
        }
        return true;
      }
    }
  }
  
  public void b()
  {
    BaseMsgView localBaseMsgView = a();
    if ((localBaseMsgView == null) || (!localBaseMsgView.a())) {
      return;
    }
    localBaseMsgView.b();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView != null) {
      this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.e();
    }
  }
  
  public void setData(int paramInt, MQMsg paramMQMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramMQMsg == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
      this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
      this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView = null;
    }
    label898:
    label908:
    for (;;)
    {
      return;
      Object localObject;
      label115:
      int i;
      if (paramBoolean2)
      {
        String str = new SimpleDateFormat("MM月dd日").format(new Date(paramMQMsg.pushTime * 1000L));
        localObject = str;
        if (str.startsWith("0")) {
          localObject = str.substring(1);
        }
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        if (!paramBoolean1) {
          break label795;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-11580352);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-15263977);
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130848496);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130848496);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-5723992);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130848471);
        label194:
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(bhtq.a(5.0F), 0, bhtq.a(5.0F), 0);
        this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
        if (paramBoolean2)
        {
          localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
          ((TextView)localObject).setPadding(bhtq.a(12.0F), 0, 0, 0);
          ((TextView)localObject).setGravity(16);
          ((TextView)localObject).setTextSize(17.0F);
          if (!paramBoolean1) {
            break label876;
          }
          i = -198683;
          label277:
          ((TextView)localObject).setTextColor(i);
          if ((paramMQMsg.msgType == 10) || (paramMQMsg.msgType == 11)) {
            ((TextView)localObject).setTypeface(Typeface.DEFAULT_BOLD);
          }
          ((TextView)localObject).setText(paramMQMsg.title);
          this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, bhtq.a(51.0F)));
          localObject = new View(this.jdField_a_of_type_AndroidContentContext);
          if (!paramBoolean1) {
            break label884;
          }
          i = -15066598;
          label364:
          ((View)localObject).setBackgroundColor(i);
          this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
        }
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView = new MsgPhotoView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.setApp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView;
        if (this.h != paramInt) {
          break label892;
        }
        paramBoolean2 = true;
        label432:
        ((MsgPhotoView)localObject).setData(paramBoolean2, paramMQMsg, paramBoolean1);
        this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView.setMsgOnClickListener(this.jdField_a_of_type_Bmyo);
        this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView(this.jdField_a_of_type_CooperationQzoneContentboxMsgPhotoView);
        this.h = paramInt;
        if ((paramMQMsg.bottomCell == null) || (paramMQMsg.bottomCell.userAvatar == null) || (paramMQMsg.bottomCell.userAvatar.size() <= 0)) {
          break label898;
        }
        this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
        localObject = new MsgMoreView(this.jdField_a_of_type_AndroidContentContext);
        ((MsgMoreView)localObject).setData(paramMQMsg, paramBoolean1);
        ((MsgMoreView)localObject).setMsgOnClickListener(this.jdField_a_of_type_Bmyo);
        this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setVisibility(0);
        this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView((View)localObject);
      }
      for (;;)
      {
        if ((!apbx.a(paramMQMsg.expand)) || (!apbx.a(paramMQMsg.pushTime))) {
          break label908;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setDarkMode(paramBoolean1);
        paramMQMsg = paramMQMsg.expand;
        localObject = apbx.a((String)paramMQMsg.get("metaData"));
        if (this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.a()) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.a((String)paramMQMsg.get("appname"), (String)paramMQMsg.get("appview"), (String)paramMQMsg.get("appversion"), (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MsgCardView", 1, "QQDailyArkView exposed");
        }
        bdll.b(null, "dc00898", "", "", "0X800AC01", "0X800AC01", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.setExpReported(true);
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof QZoneMsgActivity)) {
          break;
        }
        ((QZoneMsgActivity)this.jdField_a_of_type_AndroidContentContext).a.a(this.jdField_a_of_type_ComTencentMobileqqAppQqdailyQQDailyArkView.a);
        return;
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMQMsg.title);
        a(paramMQMsg.pushTime * 1000L);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        break label115;
        label795:
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16777216);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5196865);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundColor(-1);
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130848495);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130848495);
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16578534);
        this.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130848470);
        break label194;
        label876:
        i = -16578534;
        break label277;
        label884:
        i = -1315339;
        break label364;
        label892:
        paramBoolean2 = false;
        break label432;
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
    }
  }
  
  public void setMsgOnClickListener(bmyo parambmyo)
  {
    this.jdField_a_of_type_Bmyo = parambmyo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgCardView
 * JD-Core Version:    0.7.0.1
 */