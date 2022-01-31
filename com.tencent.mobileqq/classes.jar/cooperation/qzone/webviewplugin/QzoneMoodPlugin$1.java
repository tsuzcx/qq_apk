package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.text.TextUtils;
import bcdb;
import bgxy;
import bhrr;
import bhrs;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.model.PublishEventTag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class QzoneMoodPlugin$1
  implements Runnable
{
  public QzoneMoodPlugin$1(bhrr parambhrr, ArrayList paramArrayList1, String paramString1, int paramInt, Activity paramActivity, String paramString2, ArrayList paramArrayList2, PublishEventTag paramPublishEventTag) {}
  
  public void run()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      if (bhrr.a().isEmpty()) {
        bhrr.a(this.this$0);
      }
      localObject1 = bhrr.a().iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (bhrs)((Iterator)localObject1).next();
      } while ((localObject2 == null) || (((bhrs)localObject2).jdField_a_of_type_JavaLangString == null) || (((bhrs)localObject2).jdField_a_of_type_JavaUtilHashMap == null) || (!((bhrs)localObject2).jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_JavaLangString)));
    }
    for (Object localObject1 = ((bhrs)localObject2).jdField_a_of_type_JavaUtilHashMap;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          String str = (String)((HashMap)localObject1).get(localResultRecord.jdField_a_of_type_JavaLangString);
          if (!TextUtils.isEmpty(str)) {
            localResultRecord.jdField_b_of_type_JavaLangString = str;
          }
        }
      }
      if (this.jdField_a_of_type_Int == 1)
      {
        bgxy.b(this.jdField_a_of_type_AndroidAppActivity, this.this$0.a.mRuntime.a().getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_CooperationQzoneModelPublishEventTag, -1);
        return;
      }
      bgxy.a(this.jdField_a_of_type_AndroidAppActivity, this.this$0.a.mRuntime.a().getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_CooperationQzoneModelPublishEventTag, -1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QzoneMoodPlugin.1
 * JD-Core Version:    0.7.0.1
 */