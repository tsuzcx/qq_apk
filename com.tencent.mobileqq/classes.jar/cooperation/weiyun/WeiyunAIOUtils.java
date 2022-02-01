package cooperation.weiyun;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class WeiyunAIOUtils
{
  public static void a(Activity paramActivity)
  {
    String str = String.format("https://jump.weiyun.com?from=3092&aid=%s", new Object[] { "qq_an_wyshouxian" });
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramActivity.startActivityForResult(localIntent, 21);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList6 = new ArrayList();
    ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).setRequestData(localChatMessage.frienduin, localChatMessage.senderuin, localChatMessage.istroop);
    int i = 0;
    while (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((localChatMessage instanceof MessageForTroopFile)) {
        localArrayList1.add(localChatMessage);
      } else if ((localChatMessage instanceof MessageForFile)) {
        localArrayList2.add((MessageForFile)localChatMessage);
      } else if ((localChatMessage instanceof MessageForDLFile)) {
        localArrayList3.add((MessageForDLFile)localChatMessage);
      } else if ((localChatMessage instanceof MessageForPic)) {
        localArrayList4.add((MessageForPic)localChatMessage);
      } else if (MultiMsgProxy.b(localChatMessage)) {
        localArrayList6.add((StructMsgForImageShare)((MessageForStructing)localChatMessage).structingMsg);
      }
      i += 1;
    }
    if (localArrayList1.size() > 0)
    {
      paramList = (ChatMessage)localArrayList1.get(0);
      if (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramList.frienduin)) == null) {
        return false;
      }
      paramList = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramList);
      if (paramList != null)
      {
        if (paramList.r == null) {
          return false;
        }
        TroopFileUtils.a(paramActivity, paramQQAppInterface, localArrayList1);
      }
      else
      {
        return false;
      }
    }
    boolean bool;
    if ((localArrayList2.size() <= 0) && (localArrayList3.size() <= 0)) {
      bool = a(paramQQAppInterface, localArrayList4, localArrayList5, localArrayList6, paramMqqHandler, paramInt);
    } else {
      bool = a(paramQQAppInterface, localArrayList2, localArrayList3, localArrayList4, localArrayList5, localArrayList6, paramMqqHandler, paramInt);
    }
    if (bool)
    {
      QQToast.makeText(paramQQAppInterface.getApp(), 2131889761, 0).show(paramInt);
      return true;
    }
    QQToast.makeText(paramQQAppInterface.getApp(), 2131889814, 0).show(paramInt);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, MqqHandler paramMqqHandler)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
    if (!NetworkUtil.isNetSupport(paramActivity))
    {
      QQToast.makeText(paramQQAppInterface.getApp(), 2131889169, 0).show(paramInt);
      return false;
    }
    List localList = MultiMsgManager.a().i();
    if (localList.size() == 0)
    {
      QQToast.makeText(paramQQAppInterface.getApp(), 2131896469, 0).show(paramInt);
      return false;
    }
    if (localList.size() == 1) {
      return b(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
    }
    return a(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, ArrayList<MessageForPic> paramArrayList, ArrayList<MessageForShortVideo> paramArrayList1, ArrayList<StructMsgForImageShare> paramArrayList2, MqqHandler paramMqqHandler, int paramInt)
  {
    if (((paramArrayList != null) && (paramArrayList.size() > 0)) || ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) || ((paramArrayList2 != null) && (paramArrayList2.size() > 0)))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList2 = paramArrayList2.iterator();
        label58:
        if (paramArrayList2.hasNext())
        {
          Iterator localIterator = ((StructMsgForImageShare)paramArrayList2.next()).mStructMsgItemLists.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label58;
            }
            Object localObject1 = (AbsStructMsgElement)localIterator.next();
            if (!AbsStructMsgItem.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = ((AbsStructMsgItem)localObject1).ax.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
              if (StructMsgItemImage.class.isInstance(localObject2))
              {
                localObject2 = (StructMsgItemImage)localObject2;
                if ((!a(((StructMsgItemImage)localObject2).aF)) && (!ZhituManager.a(((StructMsgItemImage)localObject2).aF))) {
                  localArrayList.add(((StructMsgItemImage)localObject2).aF);
                }
              }
            }
          }
        }
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramArrayList2 = (MessageForPic)paramArrayList.next();
          if ((!a(paramArrayList2)) && (!ZhituManager.a(paramArrayList2))) {
            localArrayList.add(paramArrayList2);
          }
        }
      }
      if ((localArrayList.size() == 0) && ((paramArrayList1 == null) || (paramArrayList1.size() == 0))) {
        return false;
      }
      paramQQAppInterface.getFileManagerEngine().d().a(localArrayList, paramArrayList1, new WeiyunAIOUtils.WeiyunCallbackImpl(paramMqqHandler, paramQQAppInterface.getApp(), paramQQAppInterface, paramInt));
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, List<MessageForFile> paramList, List<MessageForDLFile> paramList1, ArrayList<MessageForPic> paramArrayList, ArrayList<MessageForShortVideo> paramArrayList1, ArrayList<StructMsgForImageShare> paramArrayList2, MqqHandler paramMqqHandler, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label20:
    Object localObject1;
    Object localObject2;
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((FileManagerEntity)localObject2).fileSize)
    {
      localObject1 = (MessageForFile)localIterator.next();
      localObject2 = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localObject1);
      if ((((FileManagerEntity)localObject2).cloudType == 0) || (((FileManagerEntity)localObject2).status == 16)) {
        break label20;
      }
      localArrayList.add(localObject1);
    }
    localIterator = paramList1.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (MessageForDLFile)localIterator.next();
      int i = ((MessageForDLFile)localObject1).deviceType;
      long l2 = ((MessageForDLFile)localObject1).associatedId;
      localObject2 = paramQQAppInterface.getMessageFacade().d(i).a(l2);
      if (FileUtils.fileExistsAndNotEmpty(((DataLineMsgRecord)localObject2).path))
      {
        l1 += ((DataLineMsgRecord)localObject2).filesize;
        localArrayList.add(localObject1);
      }
    }
    if ((paramList.size() + paramList1.size() > 0) && (localArrayList.size() == 0))
    {
      FMToastUtil.a(2131889580);
      return false;
    }
    if ((FileManagerUtil.b()) && (l1 > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      FMDialogUtil.a(BaseActivity.sTopActivity, 2131889584, 2131889589, new WeiyunAIOUtils.4(paramQQAppInterface, paramList, paramList1, paramArrayList, paramArrayList1, paramArrayList2, paramMqqHandler, paramInt));
      return false;
    }
    return b(paramQQAppInterface, paramList, paramList1, paramArrayList, paramArrayList1, paramArrayList2, paramMqqHandler, paramInt);
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    return (HotChatHelper.a(paramChatMessage)) || (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramChatMessage));
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((FileManagerUtil.b()) && (paramDataLineMsgRecord.filesize > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
    {
      if (FreeWifiHelper.a(paramActivity, 5, new WeiyunAIOUtils.5(paramQQAppInterface, paramActivity, paramDataLineMsgRecord))) {
        FMDialogUtil.a(paramActivity, 2131889584, 2131889587, new WeiyunAIOUtils.6(paramQQAppInterface, paramActivity, paramDataLineMsgRecord));
      }
    }
    else {
      c(paramQQAppInterface, paramActivity, paramDataLineMsgRecord);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    paramList = (ChatMessage)paramList.get(0);
    ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).setRequestData(paramList.frienduin, paramList.senderuin, paramList.istroop);
    if ((paramList instanceof MessageForTroopFile))
    {
      TroopFileUtils.b(paramActivity, paramQQAppInterface, paramList);
    }
    else if ((paramList instanceof MessageForFile))
    {
      paramActivity = (MessageForFile)paramList;
      paramMqqHandler = FileManagerUtil.a(paramQQAppInterface, paramActivity);
      if (paramMqqHandler.cloudType == 0)
      {
        FMToastUtil.a(2131889580);
        return false;
      }
      if (paramMqqHandler.status == 16)
      {
        FMToastUtil.a(2131889788);
        return false;
      }
      if (FileModel.a(paramActivity).a(false))
      {
        if (FreeWifiHelper.a(BaseActivity.sTopActivity, 5, new WeiyunAIOUtils.1(paramQQAppInterface, paramList))) {
          FMDialogUtil.a(BaseActivity.sTopActivity, 2131889584, 2131889587, new WeiyunAIOUtils.2(paramQQAppInterface, paramList));
        }
      }
      else {
        FileManagerUtil.a(paramQQAppInterface, paramList, BaseActivity.sTopActivity);
      }
    }
    else
    {
      boolean bool = paramList instanceof MessageForPic;
      if ((!bool) && (!(paramList instanceof MessageForShortVideo)))
      {
        if ((paramList instanceof MessageForDLFile))
        {
          paramList = (MessageForDLFile)paramList;
          paramInt = paramList.deviceType;
          long l = paramList.associatedId;
          paramList = paramQQAppInterface.getMessageFacade().d(paramInt).a(l);
          if (paramList != null)
          {
            if (!FileUtils.fileExistsAndNotEmpty(paramList.path))
            {
              FMToastUtil.a(2131889580);
              return false;
            }
            b(paramQQAppInterface, paramActivity, paramList);
          }
        }
        else if (MultiMsgProxy.b(paramList))
        {
          paramList = (StructMsgForImageShare)((MessageForStructing)paramList).structingMsg;
          paramActivity = new ArrayList();
          paramList = paramList.mStructMsgItemLists.iterator();
          while (paramList.hasNext())
          {
            Object localObject1 = (AbsStructMsgElement)paramList.next();
            if (AbsStructMsgItem.class.isInstance(localObject1))
            {
              localObject1 = ((AbsStructMsgItem)localObject1).ax.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
                if (StructMsgItemImage.class.isInstance(localObject2))
                {
                  localObject2 = (StructMsgItemImage)localObject2;
                  if (!a(((StructMsgItemImage)localObject2).aF)) {
                    paramActivity.add(((StructMsgItemImage)localObject2).aF);
                  }
                }
              }
            }
          }
          if (paramActivity.size() > 0)
          {
            a(paramQQAppInterface, paramActivity, null, null, paramMqqHandler, paramInt);
            QQToast.makeText(paramQQAppInterface.getApp(), 2131889761, 0).show(paramInt);
          }
          else
          {
            QQToast.makeText(paramQQAppInterface.getApp(), 2131889814, 0).show(paramInt);
          }
        }
        else
        {
          QQToast.makeText(paramQQAppInterface.getApp(), 2131889814, 0).show(paramInt);
          return false;
        }
      }
      else
      {
        if (a(paramList))
        {
          FMToastUtil.a(2131889580);
          return false;
        }
        if ((bool) && (ZhituManager.a((MessageForPic)paramList)))
        {
          FMToastUtil.a(2131889580);
          return false;
        }
        paramQQAppInterface.getFileManagerEngine().d().a(paramList, new WeiyunAIOUtils.WeiyunCallbackImpl(paramMqqHandler, paramActivity, paramQQAppInterface, paramInt));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ThreadManager.getUIHandler().post(new WeiyunAIOUtils.3(paramQQAppInterface, paramInt));
        } else {
          QQToast.makeText(paramQQAppInterface.getApp(), 2131889761, 0).show(paramInt);
        }
      }
    }
    return true;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, List<MessageForFile> paramList, List<MessageForDLFile> paramList1, ArrayList<MessageForPic> paramArrayList, ArrayList<MessageForShortVideo> paramArrayList1, ArrayList<StructMsgForImageShare> paramArrayList2, MqqHandler paramMqqHandler, int paramInt)
  {
    paramList = paramList.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramList.hasNext()) {
      bool1 |= FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramList.next(), BaseActivity.sTopActivity, true);
    }
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      paramList = (MessageForDLFile)paramList1.next();
      int i = paramList.deviceType;
      long l = paramList.associatedId;
      DataLineMsgRecord localDataLineMsgRecord = paramQQAppInterface.getMessageFacade().d(i).a(l);
      bool3 = FileUtils.fileExistsAndNotEmpty(localDataLineMsgRecord.path);
      if (bool3)
      {
        paramList = null;
        if (localDataLineMsgRecord.nWeiyunSessionId != 0L) {
          paramList = paramQQAppInterface.getFileManagerDataCenter().a(localDataLineMsgRecord.nWeiyunSessionId);
        }
        if (paramList == null)
        {
          localDataLineMsgRecord.nWeiyunSessionId = paramQQAppInterface.getFileManagerEngine().a(localDataLineMsgRecord.path, null, paramQQAppInterface.getAccount(), 0, false).nSessionId;
          paramQQAppInterface.getMessageFacade().d(i).f(localDataLineMsgRecord.msgId);
        }
        else
        {
          paramQQAppInterface.getFileManagerEngine().b(localDataLineMsgRecord.nWeiyunSessionId);
        }
      }
      bool1 |= bool3;
    }
    boolean bool3 = a(paramQQAppInterface, paramArrayList, paramArrayList1, paramArrayList2, paramMqqHandler, paramInt);
    if ((bool1) || (bool3)) {
      bool2 = true;
    }
    return bool2;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord.nWeiyunSessionId != 0L) {
      localObject = paramQQAppInterface.getFileManagerDataCenter().a(paramDataLineMsgRecord.nWeiyunSessionId);
    } else {
      localObject = null;
    }
    int i = DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FileManagerUtil.j(paramDataLineMsgRecord.filename));
      ((StringBuilder)localObject).append(paramActivity.getString(2131889759));
      FMToastUtil.b(((StringBuilder)localObject).toString());
      paramDataLineMsgRecord.nWeiyunSessionId = paramQQAppInterface.getFileManagerEngine().a(paramDataLineMsgRecord.path, null, paramQQAppInterface.getAccount(), 0, false).nSessionId;
      paramQQAppInterface.getMessageFacade().d(i).f(paramDataLineMsgRecord.msgId);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(FileManagerUtil.j(paramDataLineMsgRecord.filename));
    ((StringBuilder)localObject).append(paramActivity.getString(2131889759));
    FMToastUtil.b(((StringBuilder)localObject).toString());
    paramQQAppInterface.getFileManagerEngine().b(paramDataLineMsgRecord.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils
 * JD-Core Version:    0.7.0.1
 */