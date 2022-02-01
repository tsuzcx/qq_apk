package com.tencent.mobileqq.profilecard.bussiness.photowall.handler;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.ilive.photo.NowLiveGallary.ReqBody;

public class PhotoWallHandler
  extends BusinessHandler
{
  private static final String TAG = "PhotoWallHandler";
  private AppInterface mApp;
  
  protected PhotoWallHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.mApp = paramAppInterface;
  }
  
  private void handleDelPhotoWall(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleDelPhotoWall isSuc:");
      paramObject.append(bool);
      paramObject.append(" photoid:");
      paramObject.append(paramToServiceMsg);
      QLog.d("Q.qzonephotowall", 2, paramObject.toString());
    }
    notifyUI(2, bool, new Object[] { paramFromServiceMsg });
  }
  
  private void handleGetPhotoWall(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    String str2 = (String)paramToServiceMsg.getAttribute("attachInfo");
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_photo_wall_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_photo_wall_rsp)paramObject;
      EntityManager localEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
      paramObject = (QZonePhotoWall)localEntityManager.find(QZonePhotoWall.class, str1);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZonePhotoWall();
        paramToServiceMsg.uin = str1;
      }
      paramToServiceMsg.updateQzonePhotoWall(str2, paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000) {
        localEntityManager.persist(paramToServiceMsg);
      } else {
        localEntityManager.update(paramToServiceMsg);
      }
      localEntityManager.close();
      bool = true;
      paramToServiceMsg = paramFromServiceMsg;
    }
    else
    {
      paramToServiceMsg = null;
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetPhotoWall isSuc:");
      paramFromServiceMsg.append(bool);
      QLog.d("Q.qzonephotowall", 2, paramFromServiceMsg.toString());
    }
    notifyUI(1, bool, new Object[] { str2, paramToServiceMsg, str1 });
  }
  
  public void delQzonePhotoWall(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "delQzonePhotoWall");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.delPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("photo_id", paramString2);
    localToServiceMsg.addAttribute("photo_time", Long.valueOf(paramLong));
    send(localToServiceMsg);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("SQQzoneSvc.delPhotoWall");
      this.allowCmdSet.add("SQQzoneSvc.getPhotoWall");
    }
    return this.allowCmdSet;
  }
  
  public void getNowOnliveGallary(long paramLong, NowOnliveGallayCallback paramNowOnliveGallayCallback)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    ProtoUtils.a(this.mApp, paramNowOnliveGallayCallback, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void getQzonePhotoWall(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getQzonePhotoWall uin:");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("Q.qzonephotowall", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("SQQzoneSvc.getPhotoWall");
    ((ToServiceMsg)localObject).addAttribute("uin", paramString1);
    ((ToServiceMsg)localObject).addAttribute("attachInfo", paramString2);
    send((ToServiceMsg)localObject);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return PhotoWallObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      return;
    }
    if ("SQQzoneSvc.getPhotoWall".equals(str))
    {
      handleGetPhotoWall(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("SQQzoneSvc.delPhotoWall".equals(str)) {
      handleDelPhotoWall(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler
 * JD-Core Version:    0.7.0.1
 */