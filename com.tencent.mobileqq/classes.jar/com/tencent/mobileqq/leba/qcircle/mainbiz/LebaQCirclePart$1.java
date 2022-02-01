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
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleCounter.RedPointJumpInfo;

class LebaQCirclePart$1
  implements Runnable
{
  LebaQCirclePart$1(LebaQCirclePart paramLebaQCirclePart, QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    this.this$0.e = null;
    boolean bool4 = QZConfigProviderUtil.a();
    Object localObject3 = QCircleUtils.b().getOuterEntranceRedPointInfoByAppid("circle_entrance");
    long l;
    int k;
    boolean bool3;
    Object localObject1;
    boolean bool2;
    boolean bool1;
    String str;
    int j;
    if (localObject3 != null)
    {
      l = ((QQCircleCounter.RedPointInfo)localObject3).outLayerInfo.combineRedTypes.get();
      k = ((QQCircleCounter.RedPointInfo)localObject3).redTotalNum.get();
      if (k > 0) {
        i = k + 0;
      } else {
        i = 0;
      }
      bool3 = QCircleHostUtil.checkOperateMaskEnabled(l, 1);
      localObject1 = ((QQCircleCounter.RedPointInfo)localObject3).rptRedInfo.get();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(((QQCircleCounter.RedDisplayInfo)((Iterator)localObject1).next()).headImg.get());
        }
      }
      if (!TextUtils.isEmpty(((QQCircleCounter.RedPointInfo)localObject3).wording.get())) {
        localObject1 = ((QQCircleCounter.RedPointInfo)localObject3).wording.get();
      } else {
        localObject1 = null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showPromotionRedDot");
      ((StringBuilder)localObject2).append(false);
      QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showPromotionRedDot");
      ((StringBuilder)localObject2).append(false);
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(QCircleHostUtil.checkOperateMaskEnabled(l, 3));
      QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 2, ((StringBuilder)localObject2).toString());
      bool2 = QCircleHostUtil.checkOperateMaskEnabled(l, 6);
      if (QCircleHostUtil.checkOperateMaskEnabled(l, 3))
      {
        if (((QQCircleCounter.RedPointInfo)localObject3).redJumpInfo.has())
        {
          localObject2 = ((QQCircleCounter.RedPointInfo)localObject3).redJumpInfo.redPointSources.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0) && (((List)localObject2).contains(Integer.valueOf(3)))) {
            this.this$0.e = ((QQCircleCounter.RedPointInfo)localObject3).redJumpInfo.jumpLink.get();
          }
        }
        bool1 = true;
      }
      else
      {
        bool1 = false;
      }
      str = ((QQCircleCounter.RedPointInfo)localObject3).extend.get();
      if ((i <= 0) && (!bool3) && (!bool1) && (!bool2))
      {
        j = i;
        i = -1;
        localObject2 = null;
      }
      else
      {
        localObject2 = ((QQCircleCounter.RedPointInfo)localObject3).transInfo.get();
        if ((localObject2 != null) && (((ByteStringMicro)localObject2).size() > 0)) {
          localObject2 = ((ByteStringMicro)localObject2).toByteArray();
        } else {
          localObject2 = null;
        }
        int m = ((QQCircleCounter.RedPointInfo)localObject3).tabType.get();
        j = i;
        i = m;
      }
    }
    else
    {
      l = 0L;
      localObject2 = null;
      i = -1;
      j = 0;
      bool2 = false;
      bool1 = false;
      k = 0;
      localObject1 = null;
      bool3 = false;
      str = null;
    }
    localObject3 = this.this$0;
    ((LebaQCirclePart)localObject3).b = str;
    ((LebaQCirclePart)localObject3).c = ((byte[])localObject2);
    ((LebaQCirclePart)localObject3).d = i;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[updateQQCircleRedFlag]");
    ((StringBuilder)localObject2).append("  isQQCircleUseEeveeRedPoint = ");
    ((StringBuilder)localObject2).append(bool4);
    ((StringBuilder)localObject2).append(", redDotCombineTypes = ");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(", pushUnReadNum = ");
    ((StringBuilder)localObject2).append(k);
    ((StringBuilder)localObject2).append(", showActiveRedDot = ");
    ((StringBuilder)localObject2).append(bool3);
    ((StringBuilder)localObject2).append(", showPYMKRedDot = ");
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(", uinList = ");
    ((StringBuilder)localObject2).append(localArrayList);
    ((StringBuilder)localObject2).append(", showRecommendRedDot = ");
    ((StringBuilder)localObject2).append(bool1);
    ((StringBuilder)localObject2).append(", recommendRedDotWording = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", entranceTargetTabType = ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", redDotReportExt = ");
    ((StringBuilder)localObject2).append(str);
    QLog.d("QCircleEeveeRedPoint_LebaQCirclePartImpl", 2, new Object[] { localObject2 });
    int i = localArrayList.size();
    if (this.this$0.q != j)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).q = j;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (this.this$0.r != bool3)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).r = bool3;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (this.this$0.w != i)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).w = i;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (this.this$0.s)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).s = false;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (this.this$0.v != bool2)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).v = bool2;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (this.this$0.t != bool1)
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).t = bool1;
      ((LebaQCirclePart)localObject2).p = true;
    }
    if (!TextUtils.equals(this.this$0.u, (CharSequence)localObject1))
    {
      localObject2 = this.this$0;
      ((LebaQCirclePart)localObject2).u = ((String)localObject1);
      ((LebaQCirclePart)localObject2).p = true;
    }
    if ((QzoneConfig.getQQCircleShowGuideOnLebaEntrance()) && (QCircleHostConfig.isNeedShowLebaQCircleEnterGuideNew() != 0)) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    this.this$0.a(j, bool3, localArrayList, false, bool1, bool2, (String)localObject1, this.a, bool4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.1
 * JD-Core Version:    0.7.0.1
 */