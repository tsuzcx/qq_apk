package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.OStatisticInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x608.troop_member_distribute.RspBody;

class TroopMoreDetailView$GetTroopMemberDistributeObserver
  implements BusinessObserver
{
  private final WeakReference<TroopMoreDetailView> a;
  
  public TroopMoreDetailView$GetTroopMemberDistributeObserver(TroopMoreDetailView paramTroopMoreDetailView)
  {
    this.a = new WeakReference(paramTroopMoreDetailView);
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = (TroopMoreDetailView)this.a.get();
    if (localObject1 == null) {
      return;
    }
    if (TroopMoreDetailView.b((TroopMoreDetailView)localObject1) == null) {
      return;
    }
    if (!paramBoolean) {
      return;
    }
    Object localObject2 = paramBundle.getByteArray("data");
    if (localObject2 == null) {
      return;
    }
    Context localContext = ((TroopMoreDetailView)localObject1).getContext();
    if (localContext == null) {
      return;
    }
    try
    {
      paramBundle = new troop_member_distribute.RspBody();
      paramBundle.mergeFrom((byte[])localObject2);
      if (paramBundle.uint32_result.get() != 0) {
        return;
      }
      localObject2 = paramBundle.rpt_msg_statistic.get();
      int i = paramBundle.uint32_group_member.get();
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMoreDetailView", 2, "mGetTroopMemberDistributeObserver.onReceive: memberCount should not be 0!");
        }
      }
      else
      {
        View localView = localObject1.i[5];
        StringBuffer localStringBuffer = new StringBuffer(((TroopMoreDetailView)localObject1).getResources().getString(2131917567));
        if (localView == null) {
          return;
        }
        if (((List)localObject2).size() < 4) {
          return;
        }
        localView.setVisibility(0);
        if (localObject1.i[4] != null) {
          localObject1.i[4].setBackgroundResource(2130839629);
        }
        localStringBuffer.append(",本群共");
        localStringBuffer.append(i);
        localStringBuffer.append("人");
        paramBundle = localView.findViewById(2131448023);
        Typeface localTypeface = Typeface.createFromAsset(localContext.getAssets(), "fonts/qq_font_troop_member_number.ttf");
        paramInt = 0;
        while (paramInt < ((List)localObject2).size())
        {
          localObject1 = new int[2];
          Object localObject4 = (troop_member_distribute.OStatisticInfo)((List)localObject2).get(paramInt);
          Object localObject3 = ((troop_member_distribute.OStatisticInfo)localObject4).bytes_desc.get().toStringUtf8().split("-");
          if (paramInt != 0)
          {
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3) {
                  break label610;
                }
                paramBundle = localView.findViewById(2131448026);
                localObject1 = CylinderProgressView.a(CylinderProgressView.a(localObject3[0]));
                break label613;
              }
              paramBundle = localView.findViewById(2131448025);
              localObject1 = CylinderProgressView.getLocationProgressShaderColors();
              break label613;
            }
            paramBundle = localView.findViewById(2131448024);
            localObject1 = CylinderProgressView.a(localObject3[0].contains(localContext.getString(2131891484)));
            break label613;
          }
          paramBundle = localView.findViewById(2131448023);
          localObject1 = CylinderProgressView.getActiveProgressShaderColors();
          int j = ((troop_member_distribute.OStatisticInfo)localObject4).uint32_count.get() * 100 / i;
          localObject4 = (TextView)paramBundle.findViewById(2131448636);
          ((TextView)localObject4).setTextColor(localObject1[0]);
          ((TextView)localObject4).setTypeface(localTypeface);
          CylinderProgressView localCylinderProgressView = (CylinderProgressView)paramBundle.findViewById(2131445176);
          localCylinderProgressView.setProgressStartColor(localObject1[0]);
          localCylinderProgressView.setProgressEndColor(localObject1[1]);
          localCylinderProgressView.setMax(100);
          localCylinderProgressView.setProgress(j, (TextView)localObject4);
          localStringBuffer.append(", 百分之");
          localStringBuffer.append(j);
          localStringBuffer.append("为");
          localStringBuffer.append(localObject3[0]);
          ((TextView)paramBundle.findViewById(2131447463)).setText(localObject3[0]);
          ((TextView)paramBundle.findViewById(2131439506)).setText(localObject3[1]);
          localObject3 = (TextView)paramBundle.findViewById(2131448635);
          ((TextView)localObject3).setTextColor(localObject1[0]);
          ((TextView)localObject3).setTypeface(localTypeface);
          paramInt += 1;
        }
        localView.setContentDescription(localStringBuffer);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMoreDetailView", 2, paramBundle, new Object[0]);
      }
      return;
    }
    return;
    label610:
    label613:
    for (;;)
    {
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView.GetTroopMemberDistributeObserver
 * JD-Core Version:    0.7.0.1
 */