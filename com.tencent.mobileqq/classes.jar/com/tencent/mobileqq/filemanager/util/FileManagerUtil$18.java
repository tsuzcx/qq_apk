package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import apug;
import bbdv;
import bbjc;
import bbnc;
import bbnf;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public final class FileManagerUtil$18
  implements Runnable
{
  public FileManagerUtil$18(Context paramContext, int paramInt, String paramString1, QQAppInterface paramQQAppInterface, String paramString2) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
      BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int, (BitmapFactory.Options)localObject1);
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Object localObject2 = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_Int, (BitmapFactory.Options)localObject1);
      int i = bbdv.a(this.jdField_a_of_type_AndroidContentContext);
      localObject1 = localObject2;
      if (((Bitmap)localObject2).getWidth() != i) {
        if (bbnf.c) {
          break label158;
        }
      }
      label158:
      for (localObject1 = bbnc.a().a((Bitmap)localObject2, i); Build.VERSION.SDK_INT < 26; localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, i, i, false))
      {
        localObject2 = new Intent("android.intent.action.MAIN");
        ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
        ((Intent)localObject2).putExtra(this.jdField_a_of_type_JavaLangString, true);
        ((Intent)localObject2).setClassName(this.jdField_a_of_type_AndroidContentContext, JumpActivity.class.getName());
        ((Intent)localObject2).setFlags(337641472);
        bbjc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Intent)localObject2, this.b, (Bitmap)localObject1);
        return;
      }
      apug.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileManagerUtil.18
 * JD-Core Version:    0.7.0.1
 */