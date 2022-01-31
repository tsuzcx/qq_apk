package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionCompleteInvalidAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  protected Button a;
  protected LinearLayout a;
  protected EmoticonPackage a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  protected int f;
  protected int g;
  
  public EmotionCompleteInvalidAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    this.f = (XPanelContainer.jdField_a_of_type_Int - (int)paramContext.getResources().getDimension(2131558705));
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (paramEmoticonPackage.mobileFeetype != 4) {
        break;
      }
      this.g = 1;
      return;
    }
    this.g = 2;
  }
  
  private LinearLayout a(EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder paramEmotionCompletedInvalidViewHolder)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-16777216);
    localLinearLayout.getBackground().setAlpha(178);
    localLinearLayout.setGravity(16);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f));
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    localTextView.setGravity(1);
    localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new Button(this.jdField_a_of_type_AndroidContentContext);
    ((Button)localObject).setId(2131364459);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.jdField_a_of_type_Float));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.jdField_a_of_type_Float));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838516));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.jdField_a_of_type_Float * 30.0F), 0, (int)(this.jdField_a_of_type_Float * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    paramEmotionCompletedInvalidViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = localLinearLayout;
    paramEmotionCompletedInvalidViewHolder.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    paramEmotionCompletedInvalidViewHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)localObject);
    return localLinearLayout;
  }
  
  private void b(View paramView, EmotionPanelData paramEmotionPanelData)
  {
    if ((paramView == null) || (paramEmotionPanelData == null))
    {
      QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI contentView or info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "updateUI");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      paramView.setVisibility(0);
      if (!(paramEmotionPanelData instanceof EmoticonInfo)) {
        break label107;
      }
    }
    label107:
    for (paramEmotionPanelData = (EmoticonInfo)paramEmotionPanelData;; paramEmotionPanelData = null)
    {
      if (paramEmotionPanelData == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView = (URLImageView)paramView.findViewById(2131361968);
      paramView.setImageDrawable(paramEmotionPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float));
      paramView.setVisibility(0);
      return;
      super.a(paramView, paramEmotionPanelData);
      return;
    }
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)paramViewHolder;
    paramViewGroup = paramView;
    label104:
    label237:
    int i;
    int j;
    label284:
    int m;
    int n;
    if (paramView == null)
    {
      paramViewGroup = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      LinearLayout localLinearLayout = a((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject);
      if (!this.jdField_a_of_type_Boolean) {
        break label356;
      }
      paramView = EmotionPanelViewPool.a().a(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        paramViewHolder = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 7, this.jdField_a_of_type_Int);
        if (!this.jdField_a_of_type_Boolean) {
          break label476;
        }
        a(11, paramViewHolder);
        paramViewGroup.addView(paramViewHolder, new FrameLayout.LayoutParams(-1, this.f));
        paramViewGroup.addView(localLinearLayout);
        ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout = ((EmotionInvalidPanelLinearLayout)paramViewHolder);
        paramViewGroup.setTag(localObject);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetButton = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout;
      paramView = "立即开通";
      paramViewHolder = "会员";
      if (this.g == 2) {
        paramViewHolder = "超级会员";
      }
      paramViewHolder = "该表情为" + paramViewHolder + "专享,\n开通" + paramViewHolder + "即可使用";
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 6) {
        break label486;
      }
      paramViewHolder = "活动已到期";
      paramView = "查看详情";
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setText(paramView);
      ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      paramViewHolder = ((EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionInvalidPanelLinearLayout;
      int i1 = paramViewHolder.getChildCount();
      j = 0;
      if (j >= i1) {
        break label630;
      }
      paramView = (LinearLayout)paramViewHolder.getChildAt(j);
      if (paramInt == 0) {
        break label530;
      }
      paramView.setVisibility(8);
      m = i;
      n = paramInt;
    }
    label356:
    label486:
    int i2;
    label476:
    int k;
    label530:
    do
    {
      j += 1;
      paramInt = n;
      i = m;
      break label284;
      paramViewHolder = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
      paramViewHolder = paramView;
      break;
      paramView = EmotionPanelViewPool.a().a(10);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from inflater");
        }
        paramViewHolder = new EmotionInvalidPanelLinearLayout(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, 4, this.jdField_a_of_type_Int);
        break;
      }
      paramViewHolder = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from cache");
      paramViewHolder = paramView;
      break;
      a(10, paramViewHolder);
      break label104;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 2)
      {
        paramViewHolder = "查看详情并购买后即可使用该表情";
        paramView = "查看详情";
        break label237;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 3) {
        break label237;
      }
      paramViewHolder = "表情限免已到期开通后即可使用";
      paramView = "查看详情";
      break label237;
      i2 = paramView.getChildCount();
      k = 0;
      n = paramInt;
      m = i;
    } while (k >= i2);
    localObject = paramView.getChildAt(k);
    if (i > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      ((View)localObject).setVisibility(8);
      paramInt = 1;
    }
    for (;;)
    {
      k += 1;
      break;
      ((View)localObject).setVisibility(0);
      b((View)localObject, (EmotionPanelData)this.jdField_a_of_type_JavaUtilList.get(i));
      i += 1;
    }
    label630:
    return paramViewGroup;
  }
  
  public EmoticonPackage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new EmotionCompleteInvalidAdapter.EmotionCompletedInvalidViewHolder();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "payBack");
    }
    if (18 == paramInt) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(100);
    }
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      paramMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
      if (paramMessage != null) {
        paramMessage.obtainMessage(41).sendToTarget();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView.getId() == 2131364459)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null) {
        break label28;
      }
      QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
    }
    label28:
    do
    {
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
          break;
        }
        Object localObject = "mvip.gexinghua.android.sbp_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
        paramView = "!vip";
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
          paramView = "!svip";
        }
        paramView = "http://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + paramView + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
        }
      } while (this.jdField_a_of_type_Boolean);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid);
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
    for (;;)
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionCompleteInvalidAdapter
 * JD-Core Version:    0.7.0.1
 */