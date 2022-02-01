package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmotionBatchForwardOption
  extends ForwardPhotoOption
{
  ArrayList<String> a;
  
  public EmotionBatchForwardOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_JavaUtilArrayList = paramIntent.getStringArrayListExtra("FAV_PATH_OR_ID");
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
  }
  
  public static String a(EmoticonInfo paramEmoticonInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramEmoticonInfo instanceof IPicEmoticonInfo))
    {
      paramEmoticonInfo = ((IPicEmoticonInfo)paramEmoticonInfo).getEmoticon();
      if (paramEmoticonInfo != null)
      {
        localStringBuilder.append("MARK_EMOTION:");
        localStringBuilder.append(paramEmoticonInfo.epId);
        localStringBuilder.append("_&_");
        localStringBuilder.append(paramEmoticonInfo.eId);
      }
    }
    else if ((paramEmoticonInfo instanceof IFavoriteEmoticonInfo))
    {
      localStringBuilder.append("PIC_EMOTION:");
      localStringBuilder.append(((IFavoriteEmoticonInfo)paramEmoticonInfo).getPath());
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    int i = paramString.indexOf(":");
    if (i > 0) {
      return paramString.substring(0, i + 1);
    }
    return "";
  }
  
  public static void a(Activity paramActivity, List<EmoticonInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = a((EmoticonInfo)paramList.next());
      if ((!str.equals("")) && (!localArrayList.contains(str)))
      {
        localArrayList.add(str);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("launchFriendPicker ：");
          localStringBuilder.append(str);
          QLog.d("EmotionBatchForwardOption", 2, localStringBuilder.toString());
        }
      }
    }
    paramList = new Intent(paramActivity, ForwardRecentActivity.class);
    paramList.putExtras(new Bundle());
    paramList.putExtra("forward_type", 47);
    paramList.putExtra("selection_mode", 1);
    paramList.putExtra("key_share_from_screen_need_finish", true);
    paramList.putStringArrayListExtra("FAV_PATH_OR_ID", localArrayList);
    paramList.putExtra("k_dataline", false);
    paramActivity.startActivity(paramList);
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this.jdField_a_of_type_AndroidAppActivity, MiniChatActivity.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("minaio_scaled_ration", a(0.78F));
    localIntent.putExtra("minaio_height_ration", 0.86F);
    localIntent.putExtra("multi_forward_type", 4);
    localIntent.putStringArrayListExtra("FAV_PATH_OR_ID", paramArrayList);
    localIntent.putExtra("key_mini_from", 4);
    PublicFragmentActivity.Launcher.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
  }
  
  protected View a()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidAppActivity.getString(2131691945);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilArrayList.size());
    Object localObject3 = String.format((String)localObject1, new Object[] { ((StringBuilder)localObject2).toString() });
    localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((LinearLayout)localObject1).setOrientation(0);
    localObject2 = new EllipsizingTextView(this.jdField_a_of_type_AndroidAppActivity, null);
    ((EllipsizingTextView)localObject2).setText(new QQText((CharSequence)localObject3, 3, 16));
    ((EllipsizingTextView)localObject2).setMaxLines(2);
    ((EllipsizingTextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((EllipsizingTextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidAppActivity.getResources().getColorStateList(2131165661));
    ((EllipsizingTextView)localObject2).setTextSize(14.0F);
    localObject3 = new ImageView(this.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject3).setImageResource(2130840133);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 17;
    ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new LinearLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 17;
    ((LinearLayout.LayoutParams)localObject2).setMargins(ViewUtils.a(3.0F), 0, 0, 0);
    ((LinearLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localObject2 = new View(this.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject2).setBackgroundResource(2130840143);
    ((View)localObject2).setOnClickListener(new EmotionBatchForwardOption.1(this));
    localObject3 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    int i = ViewUtils.a(20.0F);
    ((FrameLayout)localObject3).setPadding(0, i, 0, i);
    ((FrameLayout)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    ((FrameLayout)localObject3).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1, 16));
    ((FrameLayout)localObject3).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -2));
    return localObject3;
  }
  
  protected void a()
  {
    ThreadManagerV2.executeOnSubThread(new EmotionBatchForwardOption.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.EmotionBatchForwardOption
 * JD-Core Version:    0.7.0.1
 */