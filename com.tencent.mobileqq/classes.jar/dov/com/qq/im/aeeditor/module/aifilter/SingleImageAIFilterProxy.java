package dov.com.qq.im.aeeditor.module.aifilter;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.data.AEEditorImageInfo;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class SingleImageAIFilterProxy
  extends AIFilterProxyBase
{
  private static final String a;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private List<AEEditorImageInfo> c;
  
  static
  {
    jdField_a_of_type_JavaLangString = SingleImageAIFilterProxy.class.getSimpleName();
  }
  
  public SingleImageAIFilterProxy(String paramString, List<AEEditorImageInfo> paramList, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = paramInt;
    this.c = paramList;
  }
  
  public AIFilterResult a(List<AIFilterResponse> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (AIFilterResponse)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        AEQLog.d(jdField_a_of_type_JavaLangString, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, AIFilterProxyBase.AIFilterProxyCallback paramAIFilterProxyCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_Int = 1;
    ThreadManager.getSubThreadHandler().post(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, paramAIFilterProxyCallback));
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy
 * JD-Core Version:    0.7.0.1
 */