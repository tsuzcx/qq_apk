package com.tencent.mobileqq.text.processor;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.GrabParams;
import com.tencent.mobileqq.text.LinkSpanEntity;
import com.tencent.mobileqq.text.QQTextParseLinkUtil;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQLinkSpanProcessor
  implements ISpanProcessor
{
  public static String a;
  
  public void doGrab(GrabParams paramGrabParams, ISpanCallback paramISpanCallback)
  {
    LinkSpanEntity localLinkSpanEntity = null;
    if ((paramGrabParams == null) || (paramISpanCallback == null)) {}
    Object localObject1;
    label52:
    do
    {
      return;
      if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
      {
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject1 != null) {
          jdField_a_of_type_JavaLangString = ((AppRuntime)localObject1).getAccount();
        }
        if (jdField_a_of_type_JavaLangString != null) {
          break;
        }
        localObject1 = "";
        jdField_a_of_type_JavaLangString = (String)localObject1;
      }
    } while (paramGrabParams.text == null);
    Object localObject2;
    if ((jdField_a_of_type_JavaLangString.length() > 3) && (jdField_a_of_type_JavaLangString.charAt(jdField_a_of_type_JavaLangString.length() - 3) == '0') && (jdField_a_of_type_JavaLangString.charAt(jdField_a_of_type_JavaLangString.length() - 2) == '1'))
    {
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("length", paramGrabParams.text.length() + "");
      localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
      if (paramGrabParams.text.length() >= 1000) {
        break label325;
      }
    }
    label325:
    for (boolean bool = true;; bool = false)
    {
      ((StatisticCollector)localObject2).collectPerformance(null, "qq_url_length_report", bool, 0L, 0L, (HashMap)localObject1, null);
      if (paramGrabParams.text.length() >= 1000) {
        break;
      }
      localObject2 = QQTextParseLinkUtil.a(paramGrabParams.text);
      localObject1 = localLinkSpanEntity;
      if ((paramGrabParams.message instanceof MessageRecord)) {
        localObject1 = (MessageRecord)paramGrabParams.message;
      }
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      paramGrabParams = ((List)localObject2).iterator();
      while (paramGrabParams.hasNext())
      {
        localLinkSpanEntity = (LinkSpanEntity)paramGrabParams.next();
        paramISpanCallback.addSpan(new LinkSpan(localLinkSpanEntity.jdField_a_of_type_JavaLangString, jdField_a_of_type_JavaLangString, (MessageRecord)localObject1), localLinkSpanEntity.jdField_a_of_type_Int, localLinkSpanEntity.b, 33);
      }
      break;
      localObject1 = jdField_a_of_type_JavaLangString;
      break label52;
    }
  }
  
  public int doPlain(Object paramObject, int paramInt1, int paramInt2, int paramInt3, StringBuffer paramStringBuffer)
  {
    return 0;
  }
  
  public boolean matchGrab(int paramInt)
  {
    return (paramInt & 0x8) == 8;
  }
  
  public boolean matchPlain(Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.text.processor.QQLinkSpanProcessor
 * JD-Core Version:    0.7.0.1
 */