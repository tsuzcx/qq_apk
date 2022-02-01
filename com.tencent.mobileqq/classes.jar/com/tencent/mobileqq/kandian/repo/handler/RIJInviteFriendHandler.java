package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.InviteReq;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.Invitee;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.ReqBody;
import tencent.im.oidb.cmd0xbd4.oidb_cmd0xbd4.RspBody;

public class RIJInviteFriendHandler
  extends RIJBaseArticleInfoHandler
{
  public RIJInviteFriendHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbd4.RspBody());
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJInviteFriendHandler.1(this, paramToServiceMsg, i));
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    if ((paramInt == 1) && (paramArrayList != null) && (paramString != null))
    {
      oidb_cmd0xbd4.ReqBody localReqBody = new oidb_cmd0xbd4.ReqBody();
      oidb_cmd0xbd4.InviteReq localInviteReq = new oidb_cmd0xbd4.InviteReq();
      localInviteReq.str_rowkey.set(paramString);
      try
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramString = (ResultRecord)paramArrayList.next();
          if (a(paramString.a()))
          {
            oidb_cmd0xbd4.Invitee localInvitee = new oidb_cmd0xbd4.Invitee();
            localInvitee.uint64_uin.set(Long.parseLong(paramString.a()));
            localInvitee.uint32_from.set(paramString.a());
            localInviteReq.rpt_msg_invitee.add(localInvitee);
          }
        }
        return;
      }
      catch (NumberFormatException paramArrayList)
      {
        paramString = new StringBuilder();
        paramString.append(" e = ");
        paramString.append(paramArrayList);
        QLog.e("RIJInviteFriendHandler", 1, paramString.toString());
        paramArrayList.printStackTrace();
        localReqBody.msg_invite_req.set(localInviteReq);
        paramArrayList = ReadInJoyOidbHelper.a("OidbSvc.0xbd4_1", 3028, 1, localReqBody.toByteArray());
        this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsArticleInfoModule.sendPbReq(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJInviteFriendHandler
 * JD-Core Version:    0.7.0.1
 */