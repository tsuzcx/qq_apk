package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.provider.QZConfigProviderUtil;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleCounter.RedPointJumpInfo;
import qqcircle.QQCircleCounter.SmallRedPointInfoExt;

class LebaQCirclePart$1
  implements Runnable
{
  LebaQCirclePart$1(LebaQCirclePart paramLebaQCirclePart, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    long l = 0L;
    int k = 0;
    int m = ((Integer)QCircleChatBoxHelper.getInstance().getUnReadInfo().first).intValue();
    if (m > 0) {}
    boolean bool3;
    boolean bool2;
    Object localObject3;
    Object localObject1;
    boolean bool5;
    boolean bool1;
    boolean bool4;
    Object localObject4;
    boolean bool6;
    QQCircleCounter.RedPointInfo localRedPointInfo;
    Object localObject2;
    for (int i = m;; i = 0)
    {
      bool3 = false;
      bool2 = false;
      localObject3 = null;
      localObject1 = null;
      bool5 = false;
      bool1 = false;
      bool4 = false;
      localObject4 = null;
      this.this$0.jdField_b_of_type_JavaLangString = null;
      bool6 = QZConfigProviderUtil.a();
      localRedPointInfo = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
      if (localRedPointInfo == null) {
        break label1018;
      }
      l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
      k = localRedPointInfo.redTotalNum.get();
      if (k <= 0) {
        break label1015;
      }
      i += k;
      bool3 = bool2;
      if (QCircleHostUtil.checkOperateMaskEnabled(l, 1)) {
        bool3 = true;
      }
      localObject2 = localRedPointInfo.rptRedInfo.get();
      localObject3 = localObject1;
      if (localObject2 == null) {
        break;
      }
      localObject3 = localObject1;
      if (((List)localObject2).size() <= 0) {
        break;
      }
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        localObject3 = localObject1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        ((List)localObject1).add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject2).next()).headImg.get());
      }
    }
    label269:
    Object localObject5;
    int j;
    if (!TextUtils.isEmpty(((QQCircleCounter.SmallRedPointInfoExt)localRedPointInfo.smallRedInfoExt.get()).wording.get()))
    {
      localObject2 = ((QQCircleCounter.SmallRedPointInfoExt)localRedPointInfo.smallRedInfoExt.get()).wording.get();
      localObject1 = localObject2;
      bool2 = bool5;
      if (m <= 0)
      {
        localObject1 = localObject2;
        if (QCircleHostUtil.checkOperateMaskEnabled(l, 6))
        {
          localObject1 = localRedPointInfo.pymkRedInfo.wording.get();
          bool4 = true;
        }
        bool1 = bool4;
        bool2 = bool5;
        if (QCircleHostUtil.checkOperateMaskEnabled(l, 3))
        {
          localObject2 = localRedPointInfo.allPushInfo.wording.get();
          bool5 = true;
          localObject1 = localObject2;
          bool1 = bool4;
          bool2 = bool5;
          if (localRedPointInfo.redJumpInfo.has())
          {
            localObject5 = localRedPointInfo.redJumpInfo.redPointSources.get();
            localObject1 = localObject2;
            bool1 = bool4;
            bool2 = bool5;
            if (localObject5 != null)
            {
              localObject1 = localObject2;
              bool1 = bool4;
              bool2 = bool5;
              if (((List)localObject5).size() > 0)
              {
                localObject1 = localObject2;
                bool1 = bool4;
                bool2 = bool5;
                if (((List)localObject5).contains(Integer.valueOf(3)))
                {
                  this.this$0.jdField_b_of_type_JavaLangString = localRedPointInfo.redJumpInfo.jumpLink.get();
                  bool2 = bool5;
                  bool1 = bool4;
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
      localObject5 = localRedPointInfo.extend.get();
      if ((i > 0) || (bool3) || (bool2) || (bool1))
      {
        ByteStringMicro localByteStringMicro = localRedPointInfo.transInfo.get();
        localObject2 = localObject4;
        if (localByteStringMicro != null)
        {
          localObject2 = localObject4;
          if (localByteStringMicro.size() > 0) {
            localObject2 = localByteStringMicro.toByteArray();
          }
        }
        j = localRedPointInfo.tabType.get();
        bool4 = bool2;
        localObject4 = localObject5;
        bool2 = bool1;
        bool1 = bool4;
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_JavaLangString = localObject4;
      this.this$0.jdField_a_of_type_ArrayOfByte = ((byte[])localObject2);
      this.this$0.jdField_a_of_type_Int = j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[updateQQCircleRedFlag]").append("  isQQCircleUseEeveeRedPoint = ").append(bool6).append(", redDotCombineTypes = ").append(l).append(", pushUnReadNum = ").append(k).append(", chatUnReadNum = ").append(m).append(", showActiveRedDot = ").append(bool3).append(", showPYMKRedDot = ").append(bool2).append(", uinList = ").append(localObject3).append(", showRecommendRedDot = ").append(bool1).append(", recommendRedDotWording = ").append((String)localObject1).append(", entranceTargetTabType = ").append(j).append(", redDotReportExt = ").append(localObject4);
      QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 2, new Object[] { localObject2 });
      if (localObject3 == null) {}
      for (j = 0;; j = localObject3.size())
      {
        if (this.this$0.jdField_b_of_type_Int != i)
        {
          this.this$0.jdField_b_of_type_Int = i;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (this.this$0.jdField_b_of_type_Boolean != bool3)
        {
          this.this$0.jdField_b_of_type_Boolean = bool3;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (this.this$0.jdField_c_of_type_Int != j)
        {
          this.this$0.jdField_c_of_type_Int = j;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (this.this$0.jdField_c_of_type_Boolean)
        {
          this.this$0.jdField_c_of_type_Boolean = false;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (this.this$0.e != bool2)
        {
          this.this$0.e = bool2;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (this.this$0.d != bool1)
        {
          this.this$0.d = bool1;
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        if (!TextUtils.equals(this.this$0.jdField_c_of_type_JavaLangString, (CharSequence)localObject1))
        {
          this.this$0.jdField_c_of_type_JavaLangString = ((String)localObject1);
          this.this$0.jdField_a_of_type_Boolean = true;
        }
        this.this$0.a(i, bool3, localObject3, false, bool1, bool2, (String)localObject1, this.a);
        return;
      }
      localObject2 = null;
      j = -1;
      bool4 = bool1;
      bool1 = bool2;
      bool2 = bool4;
      localObject4 = localObject5;
      continue;
      localObject2 = null;
      break label269;
      label1015:
      break;
      label1018:
      localObject2 = null;
      localObject1 = null;
      localObject4 = null;
      j = -1;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.1
 * JD-Core Version:    0.7.0.1
 */