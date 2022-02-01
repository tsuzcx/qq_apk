package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class BatchImageAIFilterProxy
  extends AIFilterProxyBase
{
  private static final String jdField_a_of_type_JavaLangString = BatchImageAIFilterProxy.class.getSimpleName();
  private AIFilterResult jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult;
  private int b;
  private List<String> c;
  private List<AEEditorImageInfo> d;
  
  public BatchImageAIFilterProxy(List<String> paramList, List<AEEditorImageInfo> paramList1, int paramInt, AIFilterResult paramAIFilterResult)
  {
    this.c = paramList;
    this.d = paramList1;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult = paramAIFilterResult;
    this.jdField_a_of_type_Int = (paramList.size() - 1);
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
            paramList = a(null);
            paramList.jdField_a_of_type_Boolean = true;
            localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.jdField_b_of_type_JavaUtilList.size()) {
              break label210;
            }
            AEQLog.d(jdField_a_of_type_JavaLangString, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localBatchImageAIFilterResult.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_Int, (SingleImageAIFilterResult)this.jdField_a_of_type_DovComQqImAeeditorModuleAifilterAIFilterResult);
        return localBatchImageAIFilterResult;
        i = 0;
        while (i < this.jdField_a_of_type_Int)
        {
          Object localObject = (AIFilterResponse)paramList.get(i);
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.add(this.jdField_b_of_type_JavaUtilList.get(i));
          localObject = a((AIFilterResponse)localObject);
          localBatchImageAIFilterResult.jdField_a_of_type_JavaUtilList.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ArrayList localArrayList = new ArrayList(this.c);
    localArrayList.remove(this.jdField_b_of_type_Int);
    ThreadManager.getSubThreadHandler().post(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */