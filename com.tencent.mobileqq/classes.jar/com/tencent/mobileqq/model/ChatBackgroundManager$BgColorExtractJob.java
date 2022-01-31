package com.tencent.mobileqq.model;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import aufk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

class ChatBackgroundManager$BgColorExtractJob
  implements Runnable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private aufk jdField_a_of_type_Aufk;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ChatBackgroundManager$BgColorExtractJob(ChatBackgroundManager paramChatBackgroundManager, String paramString, Bitmap paramBitmap, boolean paramBoolean, aufk paramaufk)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Aufk = paramaufk;
  }
  
  public void run()
  {
    Vector localVector;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localVector = this.this$0.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if ((localVector != null) && (!localVector.isEmpty())) {
        if (this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString) != null)
        {
          ((Vector)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString)).addAll(localVector);
          if (QLog.isDevelopLevel()) {
            QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable success.");
          }
          label97:
          if (this.jdField_a_of_type_Aufk != null)
          {
            localVector = (Vector)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString);
            if ((localVector == null) || (localVector.isEmpty())) {
              break label225;
            }
          }
        }
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ChatBackgroundManager.BgColorExtractJob.1(this, bool, localVector));
      return;
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_a_of_type_JavaLangString, localVector);
      break;
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      break;
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      if (!QLog.isDevelopLevel()) {
        break label97;
      }
      QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable failed.");
      break label97;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.BgColorExtractJob
 * JD-Core Version:    0.7.0.1
 */