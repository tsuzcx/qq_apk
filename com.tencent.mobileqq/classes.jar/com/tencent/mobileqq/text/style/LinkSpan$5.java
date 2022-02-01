package com.tencent.mobileqq.text.style;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.view.View;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

final class LinkSpan$5
  implements ActionSheet.OnButtonClickListener
{
  LinkSpan$5(int paramInt, String paramString1, Context paramContext, String paramString2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt == 4)
            {
              AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, true, this.jdField_a_of_type_JavaLangString, true);
              LinkSpan.a("4", "1");
            }
          }
          else
          {
            AddFriendActivity.a(this.jdField_a_of_type_AndroidContentContext, false, this.jdField_a_of_type_JavaLangString, true);
            LinkSpan.a("3", "1");
          }
        }
        else
        {
          LinkSpan.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
          LinkSpan.b("0X800A00A", "0X800A00A");
        }
      }
      else
      {
        ((ClipboardManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
        LinkSpan.a("2", "1");
      }
    }
    else if (this.jdField_a_of_type_Int == 2)
    {
      paramView = new StringBuilder();
      paramView.append("mailto:");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView = Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse(paramView.toString())), this.jdField_a_of_type_AndroidContentContext.getString(2131693872));
      paramView.putExtra("big_brother_source_key", this.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
    }
    else
    {
      paramView = new StringBuilder();
      paramView.append("tel:");
      paramView.append(this.jdField_a_of_type_JavaLangString);
      paramView = new Intent("android.intent.action.DIAL", Uri.parse(paramView.toString()));
      paramView.putExtra("big_brother_source_key", this.b);
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      LinkSpan.a("1", "2");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.text.style.LinkSpan.5
 * JD-Core Version:    0.7.0.1
 */