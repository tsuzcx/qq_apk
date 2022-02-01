package com.tencent.mobileqq.model;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Vector;

class ChatBackgroundManager$BgColorExtractJob
  implements Runnable
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private ChatBackgroundManager.BgThemeColorExtractListener jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ChatBackgroundManager$BgColorExtractJob(ChatBackgroundManager paramChatBackgroundManager, String paramString, Bitmap paramBitmap, boolean paramBoolean, ChatBackgroundManager.BgThemeColorExtractListener paramBgThemeColorExtractListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener = paramBgThemeColorExtractListener;
  }
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null)
    {
      localObject = this.this$0.a((Bitmap)localObject);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      if ((localObject != null) && (!((Vector)localObject).isEmpty()))
      {
        if (this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString) != null) {
          ((Vector)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString)).addAll((Collection)localObject);
        } else {
          this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(this.jdField_a_of_type_JavaLangString, localObject);
        }
      }
      else {
        this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable success.");
      }
    }
    else
    {
      this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(this.jdField_a_of_type_JavaLangString);
      if (QLog.isDevelopLevel()) {
        QLog.d("ChatBackgroundManager", 4, "get Bitmap from Drawable failed.");
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqModelChatBackgroundManager$BgThemeColorExtractListener != null)
    {
      localObject = (Vector)this.this$0.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(this.jdField_a_of_type_JavaLangString);
      boolean bool;
      if ((localObject != null) && (!((Vector)localObject).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new ChatBackgroundManager.BgColorExtractJob.1(this, bool, (Vector)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.BgColorExtractJob
 * JD-Core Version:    0.7.0.1
 */