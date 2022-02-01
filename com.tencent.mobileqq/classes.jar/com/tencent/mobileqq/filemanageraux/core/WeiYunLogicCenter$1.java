package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.FileExtInfo;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.FileItem;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.LibInfoListGetMsgRsp;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

class WeiYunLogicCenter$1
  implements IWeiyunCallback<WeiyunPB.LibInfoListGetMsgRsp>
{
  WeiYunLogicCenter$1(WeiYunLogicCenter paramWeiYunLogicCenter, String paramString) {}
  
  public void a(int paramInt, String paramString, WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramLibInfoListGetMsgRsp = new StringBuilder();
      paramLibInfoListGetMsgRsp.append("queryWeiyunFileList onFailed: errcode[");
      paramLibInfoListGetMsgRsp.append(paramInt);
      paramLibInfoListGetMsgRsp.append("], errmsg[");
      paramLibInfoListGetMsgRsp.append(paramString);
      paramLibInfoListGetMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramLibInfoListGetMsgRsp.toString());
    }
    WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter().a(false, 31, new Object[] { Integer.valueOf(paramInt), paramString, this.jdField_a_of_type_JavaLangString });
  }
  
  public void a(WeiyunPB.LibInfoListGetMsgRsp paramLibInfoListGetMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryWeiyunFileList onSucceed, num[");
      ((StringBuilder)localObject1).append(paramLibInfoListGetMsgRsp.FileItem_items.size());
      ((StringBuilder)localObject1).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramLibInfoListGetMsgRsp.FileItem_items.get().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (WeiyunPB.FileItem)((Iterator)localObject2).next();
      WeiYunFileInfo localWeiYunFileInfo = new WeiYunFileInfo();
      localWeiYunFileInfo.jdField_b_of_type_Long = ((WeiyunPB.FileItem)localObject3).file_mtime.get();
      localWeiYunFileInfo.jdField_a_of_type_Long = ((WeiyunPB.FileItem)localObject3).file_size.get();
      localWeiYunFileInfo.jdField_a_of_type_Int = ((WeiyunPB.FileItem)localObject3).ext_info.from_source.get();
      localWeiYunFileInfo.jdField_a_of_type_JavaLangString = ((WeiyunPB.FileItem)localObject3).file_id.get();
      localWeiYunFileInfo.jdField_b_of_type_JavaLangString = StringUtils.a(((WeiyunPB.FileItem)localObject3).pdir_key.get());
      localWeiYunFileInfo.c = ((WeiyunPB.FileItem)localObject3).filename.get();
      localWeiYunFileInfo.f = ((WeiyunPB.FileItem)localObject3).ext_info.cookie_name.get();
      localWeiYunFileInfo.g = ((WeiyunPB.FileItem)localObject3).ext_info.cookie_value.get();
      localWeiYunFileInfo.e = ((WeiyunPB.FileItem)localObject3).ext_info.thumb_url.get();
      localWeiYunFileInfo.d = ((WeiyunPB.FileItem)localObject3).ext_info.weiyun_host.get();
      localWeiYunFileInfo.jdField_b_of_type_Int = ((WeiyunPB.FileItem)localObject3).ext_info.weiyun_port.get();
      localWeiYunFileInfo.i = StringUtils.a(((WeiyunPB.FileItem)localObject3).file_md5.get());
      localWeiYunFileInfo.j = StringUtils.a(((WeiyunPB.FileItem)localObject3).file_sha.get());
      if (!WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).containsKey(localWeiYunFileInfo.jdField_a_of_type_JavaLangString))
      {
        WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).put(localWeiYunFileInfo.jdField_a_of_type_JavaLangString, localWeiYunFileInfo);
        ((List)localObject1).add(localWeiYunFileInfo);
      }
    }
    localObject2 = WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter).getFileManagerNotifyCenter();
    Object localObject3 = this.jdField_a_of_type_JavaLangString;
    boolean bool = false;
    if (paramLibInfoListGetMsgRsp.finish_flag.get() == 1) {
      bool = true;
    }
    ((FileManagerNotifyCenter)localObject2).a(true, 31, new Object[] { localObject3, Boolean.valueOf(bool), Integer.valueOf(paramLibInfoListGetMsgRsp.FileItem_items.size()), paramLibInfoListGetMsgRsp.server_version.get(), localObject1, Integer.valueOf(WeiYunLogicCenter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxCoreWeiYunLogicCenter)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.1
 * JD-Core Version:    0.7.0.1
 */