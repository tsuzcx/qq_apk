package cooperation.troop_homework.jsp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.troop_homework.TroopHomeworkHelper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class TroopHWJsPlugin$CompressVideoJob
  implements Runnable
{
  private TroopHWJsPlugin.RequestSource jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource;
  private HashMap<Integer, String> jdField_a_of_type_JavaUtilHashMap;
  
  public TroopHWJsPlugin$CompressVideoJob(TroopHWJsPlugin.RequestSource paramRequestSource, HashMap<Integer, String> paramHashMap)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilHashMap = localObject;
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource = paramHashMap;
  }
  
  public void run()
  {
    Context localContext = this.this$0.mRuntime.a().getApplicationContext();
    VFSFile localVFSFile = new VFSFile(TroopHWJsPlugin.a);
    if (!localVFSFile.exists()) {
      localVFSFile.mkdirs();
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      int i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
      localObject1 = (String)((Map.Entry)localObject1).getValue();
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("compressVideo, path = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("TroopHWJsPlugin", 2, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        try
        {
          localObject2 = TroopHWJsPlugin.a(this.this$0, i, (String)localObject1);
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(localVFSFile.getAbsolutePath());
          ((StringBuilder)localObject3).append("/");
          ((StringBuilder)localObject3).append(new File((String)localObject1).getName());
          localObject3 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject3).toString());
          this.this$0.a(i, 0.05F);
          int j = TroopHomeworkHelper.a(localContext, (String)localObject1, (String)localObject3);
          this.this$0.a(i, 0.1F);
          if (j == 1)
          {
            localObject1 = this.this$0.a(this.this$0, i, (String)localObject1, (Bitmap)localObject2, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource, 2);
            this.this$0.b.put(Integer.valueOf(i), localObject1);
            ((TroopHWJsPlugin.UploadMediaEntry)localObject1).a();
            continue;
          }
          if ((j == 0) && (new File((String)localObject3).exists()))
          {
            localObject1 = this.this$0.a(this.this$0, i, (String)localObject3, (Bitmap)localObject2, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource, 2);
            this.this$0.b.put(Integer.valueOf(i), localObject1);
            ((TroopHWJsPlugin.UploadMediaEntry)localObject1).a();
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("CompressVideoJob failed:");
            ((StringBuilder)localObject3).append(j);
            QLog.w("TroopHWJsPlugin", 2, ((StringBuilder)localObject3).toString());
          }
          localObject1 = this.this$0.a(this.this$0, i, (String)localObject1, (Bitmap)localObject2, this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWJsPlugin$RequestSource, 2);
          this.this$0.b.put(Integer.valueOf(i), localObject1);
          ((TroopHWJsPlugin.UploadMediaEntry)localObject1).a();
        }
        catch (Exception localException)
        {
          QLog.e("TroopHWJsPlugin", 2, "compressVideo, Exception happened!", localException);
          TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(0);
        }
      }
      else
      {
        TroopHWJsPlugin.a(this.this$0).sendEmptyMessage(4);
        QLog.e("TroopHWJsPlugin", 2, "compressVideo,video empty!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.CompressVideoJob
 * JD-Core Version:    0.7.0.1
 */