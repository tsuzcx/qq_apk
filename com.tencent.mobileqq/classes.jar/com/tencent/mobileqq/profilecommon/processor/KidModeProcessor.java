package com.tencent.mobileqq.profilecommon.processor;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class KidModeProcessor
  extends AbsProfileCommonProcessor
{
  public KidModeProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public String getProcessorKey()
  {
    return "KidModeProcessor";
  }
  
  public boolean interceptProfileModifyPush(int paramInt)
  {
    return (paramInt == 42362) || (paramInt == 42432) || (paramInt == 42285) || (paramInt == 42490) || (paramInt == 42430) || (paramInt == 42429) || (paramInt == 42428) || (paramInt == 42482);
  }
  
  public void onProcessProfileModifyPush(int paramInt, ByteStringMicro paramByteStringMicro)
  {
    switch (paramInt)
    {
    default: 
    case 42428: 
    case 42429: 
    case 42430: 
    case 42482: 
    case 42490: 
      if (QLog.isColorLevel()) {
        QLog.d("KidModeProcessor", 2, "handler push fot setting change");
      }
      paramByteStringMicro = new ArrayList();
      paramByteStringMicro.add(Short.valueOf((short)paramInt));
      TempGetProfileDetailProcessor localTempGetProfileDetailProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.appRuntime, TempGetProfileDetailProcessor.class);
      if (localTempGetProfileDetailProcessor != null)
      {
        localTempGetProfileDetailProcessor.getDetailCardInfo(paramByteStringMicro, null);
        return;
      }
      break;
    case 42285: 
    case 42362: 
    case 42432: 
      if (QLog.isColorLevel()) {
        QLog.d("KidModeProcessor", 2, "handler push fot theme switch");
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecommon.processor.KidModeProcessor
 * JD-Core Version:    0.7.0.1
 */