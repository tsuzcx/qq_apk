package com.tencent.mobileqq.leba.qcircle.mainbiz;

import android.text.TextUtils;
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
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
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
    int m = QCircleChatBoxHelper.getInstance().getUnReadChatNum();
    int j;
    if (m > 0) {
      j = m;
    } else {
      j = 0;
    }
    this.this$0.jdField_b_of_type_JavaLangString = null;
    boolean bool4 = QZConfigProviderUtil.a();
    Object localObject4 = QCircleUtils.a().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    long l;
    int k;
    int i;
    boolean bool3;
    Object localObject2;
    Object localObject1;
    boolean bool2;
    boolean bool1;
    String str;
    if (localObject4 != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject4).outLayerInfo.combineRedTypes.get();
      k = ((QQCircleCounter.RedPointInfo)localObject4).redTotalNum.get();
      i = j;
      if (k > 0) {
        i = j + k;
      }
      bool3 = QCircleHostUtil.checkOperateMaskEnabled(l, 1);
      localObject2 = ((QQCircleCounter.RedPointInfo)localObject4).rptRedInfo.get();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = new ArrayList();
        localObject3 = ((List)localObject2).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          ((List)localObject1).add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject3).next()).headImg.get());
        }
      }
      localObject2 = null;
      if (!TextUtils.isEmpty(((QQCircleCounter.SmallRedPointInfoExt)((QQCircleCounter.RedPointInfo)localObject4).smallRedInfoExt.get()).wording.get())) {
        localObject1 = ((QQCircleCounter.SmallRedPointInfoExt)((QQCircleCounter.RedPointInfo)localObject4).smallRedInfoExt.get()).wording.get();
      } else {
        localObject1 = null;
      }
      if (m <= 0)
      {
        if (QCircleHostUtil.checkOperateMaskEnabled(l, 6))
        {
          localObject1 = ((QQCircleCounter.RedPointInfo)localObject4).pymkRedInfo.wording.get();
          bool2 = true;
        }
        else
        {
          bool2 = false;
        }
        if (QCircleHostUtil.checkOperateMaskEnabled(l, 3))
        {
          localObject1 = ((QQCircleCounter.RedPointInfo)localObject4).allPushInfo.wording.get();
          if (((QQCircleCounter.RedPointInfo)localObject4).redJumpInfo.has())
          {
            localObject3 = ((QQCircleCounter.RedPointInfo)localObject4).redJumpInfo.redPointSources.get();
            if ((localObject3 != null) && (((List)localObject3).size() > 0) && (((List)localObject3).contains(Integer.valueOf(3)))) {
              this.this$0.jdField_b_of_type_JavaLangString = ((QQCircleCounter.RedPointInfo)localObject4).redJumpInfo.jumpLink.get();
            }
          }
          bool1 = true;
        }
        else
        {
          bool1 = false;
        }
      }
      else
      {
        bool1 = false;
        bool2 = false;
      }
      str = ((QQCircleCounter.RedPointInfo)localObject4).extend.get();
      if ((i <= 0) && (!bool3) && (!bool1) && (!bool2))
      {
        localObject3 = null;
        j = -1;
      }
      else
      {
        localObject3 = ((QQCircleCounter.RedPointInfo)localObject4).transInfo.get();
        if ((localObject3 != null) && (((ByteStringMicro)localObject3).size() > 0)) {
          localObject3 = ((ByteStringMicro)localObject3).toByteArray();
        } else {
          localObject3 = null;
        }
        j = ((QQCircleCounter.RedPointInfo)localObject4).tabType.get();
      }
    }
    else
    {
      l = 0L;
      i = j;
      localObject3 = null;
      j = -1;
      bool1 = false;
      localObject1 = null;
      k = 0;
      bool3 = false;
      str = null;
      localObject2 = null;
      bool2 = false;
    }
    localObject4 = this.this$0;
    ((LebaQCirclePart)localObject4).jdField_a_of_type_JavaLangString = str;
    ((LebaQCirclePart)localObject4).jdField_a_of_type_ArrayOfByte = ((byte[])localObject3);
    ((LebaQCirclePart)localObject4).jdField_a_of_type_Int = j;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[updateQQCircleRedFlag]");
    ((StringBuilder)localObject3).append("  isQQCircleUseEeveeRedPoint = ");
    ((StringBuilder)localObject3).append(bool4);
    ((StringBuilder)localObject3).append(", redDotCombineTypes = ");
    ((StringBuilder)localObject3).append(l);
    ((StringBuilder)localObject3).append(", pushUnReadNum = ");
    ((StringBuilder)localObject3).append(k);
    ((StringBuilder)localObject3).append(", chatUnReadNum = ");
    ((StringBuilder)localObject3).append(m);
    ((StringBuilder)localObject3).append(", showActiveRedDot = ");
    ((StringBuilder)localObject3).append(bool3);
    ((StringBuilder)localObject3).append(", showPYMKRedDot = ");
    ((StringBuilder)localObject3).append(bool2);
    ((StringBuilder)localObject3).append(", uinList = ");
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append(", showRecommendRedDot = ");
    ((StringBuilder)localObject3).append(bool1);
    ((StringBuilder)localObject3).append(", recommendRedDotWording = ");
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(", entranceTargetTabType = ");
    ((StringBuilder)localObject3).append(j);
    ((StringBuilder)localObject3).append(", redDotReportExt = ");
    ((StringBuilder)localObject3).append(str);
    QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 2, new Object[] { localObject3 });
    if (localObject2 == null) {
      j = 0;
    } else {
      j = ((List)localObject2).size();
    }
    if (this.this$0.jdField_b_of_type_Int != i)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).jdField_b_of_type_Int = i;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (this.this$0.jdField_b_of_type_Boolean != bool3)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).jdField_b_of_type_Boolean = bool3;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (this.this$0.jdField_c_of_type_Int != j)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).jdField_c_of_type_Int = j;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (this.this$0.jdField_c_of_type_Boolean)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).jdField_c_of_type_Boolean = false;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (this.this$0.e != bool2)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).e = bool2;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (this.this$0.d != bool1)
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).d = bool1;
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if (!TextUtils.equals(this.this$0.jdField_c_of_type_JavaLangString, (CharSequence)localObject1))
    {
      localObject3 = this.this$0;
      ((LebaQCirclePart)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject1);
      ((LebaQCirclePart)localObject3).jdField_a_of_type_Boolean = true;
    }
    if ((QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) && (QCircleHostConfig.isNeedShowLebaQCircleEnterGuideNew() != 0)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    this.this$0.a(i, bool3, (List)localObject2, false, bool1, bool2, (String)localObject1, this.a, bool4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.1
 * JD-Core Version:    0.7.0.1
 */