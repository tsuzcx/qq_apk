package com.tencent.mobileqq.emosm.favroaming;

import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import mqq.os.MqqHandler;

class FavroamingManager$8$1
  implements EmoAddedAuthCallback.UploadListener
{
  private int jdField_a_of_type_Int;
  
  FavroamingManager$8$1(FavroamingManager.8 param8, List paramList) {}
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Int += 1;
    if (this.jdField_a_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0.f();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$AddCustomEmotionsCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$AddCustomEmotionsCallback.a(this.jdField_a_of_type_Int / this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
      }
    }
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_Int) {
      if (!FavroamingManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0))
      {
        paramString = (String)this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
        FavroamingManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0, paramString, FavroamingManager.a(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0));
      }
    }
    do
    {
      return;
      paramString = FavroamingManager.p(this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.this$0).getHandler(ChatActivity.class);
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$AddCustomEmotionsCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$8.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager$AddCustomEmotionsCallback.a(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8.1
 * JD-Core Version:    0.7.0.1
 */