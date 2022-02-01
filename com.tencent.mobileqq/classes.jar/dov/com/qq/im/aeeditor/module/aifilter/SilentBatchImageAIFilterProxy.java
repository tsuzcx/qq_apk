package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mqq.os.MqqHandler;

public class SilentBatchImageAIFilterProxy
  extends AIFilterProxyBase
{
  private List<String> c;
  private List<AEEditorImageInfo> d;
  
  public SilentBatchImageAIFilterProxy(@NonNull List<String> paramList, @NonNull List<AEEditorImageInfo> paramList1)
  {
    if (paramList.size() > 3) {
      this.c = paramList.subList(0, 3);
    }
    for (this.d = paramList1.subList(0, 3);; this.d = new LinkedList(paramList1))
    {
      this.jdField_a_of_type_Int = this.c.size();
      return;
      this.c = new LinkedList(paramList);
    }
  }
  
  private SingleImageAIFilterResult b(AIFilterResponse paramAIFilterResponse)
  {
    SingleImageAIFilterResult localSingleImageAIFilterResult = new SingleImageAIFilterResult();
    ArrayList localArrayList = new ArrayList();
    if (paramAIFilterResponse == null)
    {
      localSingleImageAIFilterResult.jdField_a_of_type_Boolean = true;
      AEQLog.a("SilentBatchImageAIFilterProxy", "[buildImageResult] exception");
    }
    for (paramAIFilterResponse = localArrayList;; paramAIFilterResponse = paramAIFilterResponse.jdField_a_of_type_JavaUtilList)
    {
      localSingleImageAIFilterResult.jdField_a_of_type_JavaUtilList = paramAIFilterResponse;
      return localSingleImageAIFilterResult;
    }
  }
  
  protected AIFilterResult a(List<AIFilterResponse> paramList)
  {
    int j = 0;
    BatchImageAIFilterResult localBatchImageAIFilterResult = new BatchImageAIFilterResult();
    int i;
    if ((paramList == null) || (paramList.size() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        i = j;
        for (;;)
        {
          if (i < this.jdField_a_of_type_Int)
          {
            paramList = b(null);
            paramList.jdField_a_of_type_Boolean = true;
            localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.b.size()) {
              break label188;
            }
            AEQLog.d("SilentBatchImageAIFilterProxy", "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localBatchImageAIFilterResult.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        return localBatchImageAIFilterResult;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (AIFilterResponse)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.b.get(i));
          localObject = b((AIFilterResponse)localObject);
          localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label188:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ThreadManager.getSubThreadHandler().post(new SilentBatchImageAIFilterProxy.1(this, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.SilentBatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */