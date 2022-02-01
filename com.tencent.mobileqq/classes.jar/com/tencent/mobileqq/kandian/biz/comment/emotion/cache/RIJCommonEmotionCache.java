package com.tencent.mobileqq.kandian.biz.comment.emotion.cache;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.kandian.biz.comment.emotion.RIJEmotionPanelBuilder;
import com.tencent.mobileqq.kandian.biz.comment.emotion.adapter.RIJCommonEmotionAdapterParams;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.RIJCommonEmotionInfo;
import com.tencent.mobileqq.kandian.biz.comment.emotion.data.emotionsize.IRIJEmotionSize;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RIJCommonEmotionCache
  implements IRIJEmotionCache
{
  private final int jdField_a_of_type_Int;
  private EmotionPanelInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
  private final IRIJEmotionSize jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize;
  private final String jdField_a_of_type_JavaLangString;
  private List<RIJCommonEmotionInfo> jdField_a_of_type_JavaUtilList = Collections.emptyList();
  private final Map<String, RIJCommonEmotionInfo> jdField_a_of_type_JavaUtilMap = new ArrayMap();
  private final String b;
  
  public RIJCommonEmotionCache(String paramString1, String paramString2, int paramInt, IRIJEmotionSize paramIRIJEmotionSize)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize = paramIRIJEmotionSize;
  }
  
  public Point a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(paramString, ((RIJCommonEmotionInfo)localIterator.next()).c)) {
        return new Point(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize.i(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize.j());
      }
    }
    return null;
  }
  
  @NonNull
  public EmotionInjectionInfo a(IEmoticonMainPanelApp paramIEmoticonMainPanelApp, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    paramIEmoticonMainPanelApp = new RIJCommonEmotionAdapterParams(paramIEmoticonMainPanelApp, paramContext, paramEmoticonCallback);
    int i = this.jdField_a_of_type_Int;
    paramIEmoticonMainPanelApp.b = i;
    paramIEmoticonMainPanelApp.jdField_a_of_type_Int = i;
    paramIEmoticonMainPanelApp.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize);
    paramIEmoticonMainPanelApp = new RIJEmotionPanelBuilder(paramIEmoticonMainPanelApp, this.b);
    paramIEmoticonMainPanelApp.a(this.jdField_a_of_type_JavaUtilList);
    paramContext = new EmotionInjectionInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize.a(), 0, paramIEmoticonMainPanelApp);
    paramContext.setEmotionTabCreateListener(paramIEmoticonMainPanelApp);
    return paramContext;
  }
  
  @NonNull
  public EmotionPanelInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo;
  }
  
  public RIJCommonEmotionInfo a(String paramString)
  {
    return (RIJCommonEmotionInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  @NonNull
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tkd_comment_emotion_");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
  
  public List<RIJCommonEmotionInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo = new EmotionPanelInfo(this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEmotionDataEmotionsizeIRIJEmotionSize.a(), null);
  }
  
  public void a(@NonNull List<RIJCommonEmotionInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RIJCommonEmotionInfo localRIJCommonEmotionInfo = (RIJCommonEmotionInfo)paramList.next();
      this.jdField_a_of_type_JavaUtilMap.put(localRIJCommonEmotionInfo.c, localRIJCommonEmotionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.cache.RIJCommonEmotionCache
 * JD-Core Version:    0.7.0.1
 */