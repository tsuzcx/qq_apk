package cooperation.qzone.contentbox;

import ajjy;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bajq;
import bfum;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.widget.RoundCornerLinearLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MsgCardView
  extends LinearLayout
{
  private static final int jdField_a_of_type_Int = bajq.b(35.0F);
  private static final int jdField_b_of_type_Int = bajq.b(12.0F);
  private static final int c = bajq.b(12.0F);
  private static final int d = bajq.b(10.0F);
  private static final int e = bajq.b(18.0F);
  private static final int f = bajq.b(230.0F);
  private static final int g = bajq.b(8.0F);
  private Context jdField_a_of_type_AndroidContentContext;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bfum jdField_a_of_type_Bfum;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RoundCornerLinearLayout jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCornerLinearLayout jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout;
  private int h = -1;
  
  public MsgCardView(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131496387, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131311572));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311624));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311574));
    this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout = ((RoundCornerLinearLayout)findViewById(2131304803));
    this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setRadius(g);
    this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout = ((RoundCornerLinearLayout)findViewById(2131304817));
    this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setRadius(g);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131304818));
  }
  
  private BaseMsgView a()
  {
    if ((this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout == null) || (this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.getChildCount() <= 0)) {
      return null;
    }
    return (BaseMsgView)this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.getChildAt(0);
  }
  
  private void a(long paramLong)
  {
    long l = System.currentTimeMillis() - paramLong;
    if (l < 3600000L)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajjy.a(2131641155));
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
        if (i + d + getTop() < 0) {
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
    if (this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout != null)
    {
      int j = this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        ((BaseMsgView)this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.getChildAt(i)).e();
        i += 1;
      }
    }
  }
  
  public void setData(int paramInt, MQMsg paramMQMsg)
  {
    if (paramMQMsg == null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
      this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramMQMsg.title);
    a(paramMQMsg.pushTime * 1000L);
    this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
    Object localObject = new MsgPhotoView(this.jdField_a_of_type_AndroidContentContext);
    ((MsgPhotoView)localObject).setApp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.h == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      ((MsgPhotoView)localObject).setData(bool, paramMQMsg);
      ((MsgPhotoView)localObject).setMsgOnClickListener(this.jdField_a_of_type_Bfum);
      this.jdField_a_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView((View)localObject);
      this.h = paramInt;
      if ((paramMQMsg.bottomCell == null) || (paramMQMsg.bottomCell.userAvatar == null) || (paramMQMsg.bottomCell.userAvatar.size() <= 0)) {
        break;
      }
      this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.removeAllViews();
      localObject = new MsgMoreView(this.jdField_a_of_type_AndroidContentContext);
      ((MsgMoreView)localObject).setData(paramMQMsg);
      ((MsgMoreView)localObject).setMsgOnClickListener(this.jdField_a_of_type_Bfum);
      this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.setVisibility(0);
      this.jdField_b_of_type_CooperationQzoneWidgetRoundCornerLinearLayout.addView((View)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
  }
  
  public void setMsgOnClickListener(bfum parambfum)
  {
    this.jdField_a_of_type_Bfum = parambfum;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgCardView
 * JD-Core Version:    0.7.0.1
 */