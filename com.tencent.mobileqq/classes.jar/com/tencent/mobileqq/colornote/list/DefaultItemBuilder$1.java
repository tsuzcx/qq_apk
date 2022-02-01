package com.tencent.mobileqq.colornote.list;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import mqq.app.MobileQQ;

class DefaultItemBuilder$1
  implements Runnable
{
  DefaultItemBuilder$1(DefaultItemBuilder paramDefaultItemBuilder, String paramString1, Context paramContext, String paramString2, ColorNoteListAdapter.ViewHolder paramViewHolder, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      InputStream localInputStream = MobileQQ.getContext().getAssets().open(this.jdField_a_of_type_JavaLangString);
      DefaultItemBuilder.a(this.this$0, LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_AndroidContentContext, localInputStream, new DefaultItemBuilder.1.1(this)));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DefaultItemBuilder", 2, "load lottie failed", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.DefaultItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */