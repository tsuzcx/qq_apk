package com.tencent.mobileqq.studyroom.api.impl;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.studyroom.api.IStudyRoomMisc;
import com.tencent.mobileqq.studyroom.config.StudyRoomConfProcessor;
import com.tencent.mobileqq.studyroom.ui.StudyRoomDebugSettingFragment;
import mqq.manager.Manager;

public class StudyRoomMiscImpl
  implements IStudyRoomMisc
{
  public Class<? extends QPublicBaseFragment> getDebugSettingFragmentClass()
  {
    return StudyRoomDebugSettingFragment.class;
  }
  
  public Class<? extends Manager> getManagerImplClass()
  {
    return StudyRoomManagerImpl.class;
  }
  
  public Class<? extends IQConfigProcessor> getQConfigProcessorClass()
  {
    return StudyRoomConfProcessor.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.api.impl.StudyRoomMiscImpl
 * JD-Core Version:    0.7.0.1
 */