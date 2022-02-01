package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.List;

class ReadInJoyManager$4
  implements Runnable
{
  ReadInJoyManager$4(ReadInJoyManager paramReadInJoyManager, long paramLong, String paramString1, String paramString2, List paramList) {}
  
  public void run()
  {
    if (ReadInJoyManager.a(this.this$0) == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ReadInJoyManager.a(this.this$0).edit();
    localEditor.putInt("readinjoy_push_channel_article_flag", 1);
    localEditor.putLong("readinjoy_push_channel_article_updated_time", NetConnInfoCenter.getServerTime());
    localEditor.putLong("readinjoy_push_channel_article_content_channel_id", this.jdField_a_of_type_Long);
    localEditor.putString("readinjoy_push_channel_article_content_channel_name", this.jdField_a_of_type_JavaLangString);
    localEditor.putString("readinjoy_push_channel_article_content_wording", this.b);
    localEditor.putString("readinjoy_push_channel_article_content_article_id_list", StringUtil.a(this.jdField_a_of_type_JavaUtilList, ","));
    ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).applySharedPreferences(localEditor, true);
    ReadInJoyManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyManager.4
 * JD-Core Version:    0.7.0.1
 */