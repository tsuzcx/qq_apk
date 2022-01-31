package dov.com.tencent.biz.qqstory.takevideo;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bhfc;
import bifn;
import bigb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class EditVideoInteractFace$1
  implements Runnable
{
  public EditVideoInteractFace$1(bifn parambifn) {}
  
  public void run()
  {
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      try
      {
        Object localObject = BaseApplicationImpl.getContext().getSharedPreferences("EditVideoInteractFace", 0);
        String str = bhfc.a().getCurrentAccountUin();
        int i = ((SharedPreferences)localObject).getInt(str, 0);
        if (i >= 3) {
          return;
        }
        this.this$0.a.a(44);
        bifn.a(this.this$0, LayoutInflater.from(this.this$0.a()).inflate(2131495642, null));
        bifn.a(this.this$0).findViewById(2131313495).setOnClickListener(this.this$0);
        bifn.a(this.this$0).findViewById(2131308961).setOnClickListener(this.this$0);
        RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a(2131298210);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.this$0.a.a == null) {
          break label268;
        }
        if (this.this$0.a.e)
        {
          localLayoutParams.bottomMargin = this.this$0.a.a.getHeight();
          localLayoutParams.addRule(12, -1);
          localRelativeLayout.addView(bifn.a(this.this$0), localLayoutParams);
          bifn.a(this.this$0, true);
          bifn.a(this.this$0).getViewTreeObserver().addOnGlobalLayoutListener(this.this$0);
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt(str, i + 1);
          ((SharedPreferences.Editor)localObject).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      localLayoutParams.addRule(12, -1);
      continue;
      label268:
      localLayoutParams.addRule(2, 2131298212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoInteractFace.1
 * JD-Core Version:    0.7.0.1
 */