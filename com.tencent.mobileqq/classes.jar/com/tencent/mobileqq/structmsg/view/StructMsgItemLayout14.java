package com.tencent.mobileqq.structmsg.view;

import ains;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class StructMsgItemLayout14
  extends AbsStructMsgItem
  implements View.OnClickListener
{
  public static String[] a;
  private QQAppInterface a;
  public MessageForTroopTopic a;
  private ArrayList b = new ArrayList();
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "picture", "content", "title" };
  }
  
  public StructMsgItemLayout14()
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic = null;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new ains(this, paramContext);
    paramContext.setOrientation(1);
    paramContext.setGravity(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.setMargins(AIOUtils.a(13.0F, localResources), 0, AIOUtils.a(13.0F, localResources), 0);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setId(2131362163);
    return paramContext;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  protected int b()
  {
    return 14;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout14 getView start.");
    }
    Object localObject1 = ((FragmentActivity)paramContext).getChatFragment();
    Resources localResources;
    label65:
    int m;
    int n;
    int i1;
    int i;
    label148:
    int j;
    label256:
    int k;
    if (localObject1 != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((ChatFragment)localObject1).a();
      localResources = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label344;
      }
      localObject1 = (LinearLayout)paramView;
      ((LinearLayout)localObject1).removeAllViews();
      if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) || (!(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message instanceof MessageForTroopTopic))) {
        break label1068;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic = ((MessageForTroopTopic)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
      this.b.clear();
      m = paramContext.getResources().getDisplayMetrics().widthPixels - 40 - 48;
      n = m * 400 / 666;
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
      if (i >= i1) {
        break label1068;
      }
      localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      paramView = new LinearLayout.LayoutParams(-1, -2);
      if (!(localObject2 instanceof StructMsgItemTitle)) {
        break label372;
      }
      localObject2 = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setTextSize(0, AIOUtils.a(18.0F, localResources));
      ((TextView)localObject2).setTextColor(Color.parseColor("#000000"));
      if (i != 0) {
        break label354;
      }
      j = AIOUtils.a(-3.0F, localResources);
      if (i != i1 - 1) {
        break label366;
      }
      k = AIOUtils.a(-3.0F, localResources);
      label274:
      paramView.setMargins(AIOUtils.a(2.0F, localResources), j, AIOUtils.a(2.0F, localResources), k);
      ((TextView)localObject2).setLayoutParams(paramView);
      ((LinearLayout)localObject1).addView((View)localObject2);
    }
    label344:
    label354:
    label366:
    label372:
    label511:
    do
    {
      i += 1;
      break label148;
      localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if (!(localObject1 instanceof QQAppInterface)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject1);
      break;
      localObject1 = a(paramContext);
      break label65;
      j = AIOUtils.a(10.0F, localResources);
      break label256;
      k = 0;
      break label274;
      if ((localObject2 instanceof StructMsgItemContent))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand)
        {
          ((StructMsgItemContent)localObject2).b(2147483647);
          localObject2 = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
          ((TextView)localObject2).setTextSize(0, AIOUtils.a(16.0F, localResources));
          ((TextView)localObject2).setLineSpacing(3.5F, 1.0F);
          ((TextView)localObject2).setTextColor(Color.parseColor("#333333"));
          ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
          if (i != 0) {
            break label552;
          }
          j = 0;
          paramView.setMargins(AIOUtils.a(2.0F, localResources), j, AIOUtils.a(2.0F, localResources), 0);
          ((TextView)localObject2).setLayoutParams(paramView);
          ((LinearLayout)localObject1).addView((View)localObject2);
          paramView = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
          if (i != 0) {
            break label564;
          }
          j = -6;
          if (i != i1 - 1) {
            break label573;
          }
        }
        for (k = -6;; k = paramView.bottomMargin)
        {
          paramView.topMargin = j;
          paramView.bottomMargin = k;
          break;
          ((StructMsgItemContent)localObject2).b(15);
          break label400;
          j = AIOUtils.a(10.0F, localResources);
          break label461;
          j = paramView.topMargin;
          break label511;
        }
      }
    } while (!(localObject2 instanceof StructMsgItemCover));
    label400:
    label461:
    StructMsgItemCover localStructMsgItemCover = (StructMsgItemCover)localObject2;
    label552:
    label564:
    label573:
    Object localObject2 = new AnyScaleTypeImageView(paramContext);
    ((AnyScaleTypeImageView)localObject2).setAdjustViewBounds(true);
    label637:
    ColorDrawable localColorDrawable;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand)
    {
      ((AnyScaleTypeImageView)localObject2).setDisplayRuleDef(null);
      ((AnyScaleTypeImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_START);
      paramView = null;
      if (TextUtils.isEmpty(localStructMsgItemCover.u)) {
        break label1005;
      }
      paramView = localStructMsgItemCover.u;
      label656:
      if ((localStructMsgItemCover.e == 0) || (localStructMsgItemCover.f == 0) || (TextUtils.isEmpty(paramView))) {
        break label1023;
      }
      this.b.add(paramView);
      localColorDrawable = new ColorDrawable(-1249807);
      k = localStructMsgItemCover.e;
      j = localStructMsgItemCover.f;
      if (localStructMsgItemCover.e <= m) {
        break label1086;
      }
      j = m * j / k;
      k = m;
    }
    label821:
    label1086:
    for (;;)
    {
      paramView = URLDrawable.getDrawable(paramView, k, j, localColorDrawable, localColorDrawable);
      paramView.setAutoDownload(true);
      if ((paramView != null) && (paramView.getStatus() == 2)) {
        paramView.restartDownload();
      }
      ((AnyScaleTypeImageView)localObject2).setImageDrawable(paramView);
      paramView = new LinearLayout.LayoutParams(k, j);
      if (j > m * 3)
      {
        paramView.width = (k * 3 * m / j);
        paramView.height = (m * 3);
        if (paramView.height > m * 3)
        {
          paramView.width = (paramView.width * 3 * m / paramView.height);
          paramView.height = (m * 3);
        }
        if ((!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isExpand) && (i == i1 - 1) && (paramView.height > n))
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_topic", 2, "StructMsgItemLayout14 getView. set image height " + n);
          }
          paramView.height = n;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopTopic.isShowExpandButton = true;
        }
        paramView.gravity = 3;
        if (i != 0) {
          break label1055;
        }
      }
      for (j = 0;; j = AIOUtils.a(11.0F, localResources))
      {
        paramView.setMargins(0, j, 0, 0);
        ((AnyScaleTypeImageView)localObject2).setLayoutParams(paramView);
        ((AnyScaleTypeImageView)localObject2).setTag(Integer.valueOf(this.b.size() - 1));
        ((AnyScaleTypeImageView)localObject2).setOnClickListener(this);
        ((LinearLayout)localObject1).addView((View)localObject2);
        break;
        ((AnyScaleTypeImageView)localObject2).setDisplayRuleDef(CustomScaleType.c);
        break label637;
        label1005:
        if (TextUtils.isEmpty(localStructMsgItemCover.b)) {
          break label656;
        }
        paramView = localStructMsgItemCover.b;
        break label656;
        label1023:
        break;
        if (k * 2 <= m) {
          break label821;
        }
        paramView.width = m;
        paramView.height = (j * m / k);
        break label821;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "StructingMsgItemLayout14 getView end.");
      }
      return localObject1;
    }
  }
  
  public String b()
  {
    return "Layout14";
  }
  
  public void onClick(View paramView)
  {
    Object localObject3 = paramView.getTag();
    if ((localObject3 instanceof Integer))
    {
      Object localObject2 = "";
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.frienduin;
        }
      }
      paramView = paramView.getContext();
      localObject2 = new Intent(paramView, TroopAvatarWallPreviewActivity.class);
      Bundle localBundle = new Bundle();
      ((Intent)localObject2).putExtra("index", (Integer)localObject3);
      localBundle.putStringArrayList("seqNum", this.b);
      localBundle.putBoolean("IS_EDIT", false);
      localBundle.putBoolean("is_use_path", true);
      localBundle.putBoolean("is_show_action", true);
      localBundle.putBoolean("is_not_show_index", false);
      localBundle.putBoolean("SHOW_MENU", true);
      localBundle.putBoolean("is_from_troop_topic", true);
      localBundle.putString("troop_uin", (String)localObject1);
      ((Intent)localObject2).putExtras(localBundle);
      paramView.startActivity((Intent)localObject2);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_talk", "", "obj", "aio_pic", 0, 0, (String)localObject1, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout14
 * JD-Core Version:    0.7.0.1
 */