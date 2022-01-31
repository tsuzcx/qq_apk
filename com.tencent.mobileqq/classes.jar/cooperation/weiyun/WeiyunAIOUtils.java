package cooperation.weiyun;

import amrb;
import amrc;
import amrd;
import amre;
import android.app.Activity;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.WeiYunLogicCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class WeiyunAIOUtils
{
  static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List paramList, MqqHandler paramMqqHandler)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
    ResponseHandler.a(localChatMessage.frienduin, localChatMessage.senderuin, localChatMessage.istroop);
    int i = 0;
    if (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((localChatMessage instanceof MessageForTroopFile)) {
        ((ArrayList)localObject2).add(localChatMessage);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localChatMessage instanceof MessageForFile)) {
          ((ArrayList)localObject1).add((MessageForFile)localChatMessage);
        } else if ((localChatMessage instanceof MessageForPic)) {
          localArrayList1.add((MessageForPic)localChatMessage);
        } else if ((localChatMessage instanceof MessageForShortVideo)) {
          localArrayList2.add((MessageForShortVideo)localChatMessage);
        } else if (MultiMsgProxy.c(localChatMessage)) {
          localArrayList3.add((StructMsgForImageShare)((MessageForStructing)localChatMessage).structingMsg);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramList = (ChatMessage)((ArrayList)localObject2).get(0);
      if (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramList.frienduin)) == null) {
        return false;
      }
      paramList = TroopFileUtils.a(paramQQAppInterface, (MessageForTroopFile)paramList);
      if ((paramList == null) || (paramList.e == null)) {
        return false;
      }
      TroopFileUtils.a(paramActivity, paramQQAppInterface, (List)localObject2);
    }
    boolean bool = false;
    if (((ArrayList)localObject1).size() > 0)
    {
      paramActivity = new ArrayList();
      paramList = ((ArrayList)localObject1).iterator();
      label312:
      int j;
      for (i = 0; paramList.hasNext(); i = j)
      {
        localObject1 = (MessageForFile)paramList.next();
        localObject2 = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)localObject1);
        if ((((FileManagerEntity)localObject2).cloudType == 0) || (((FileManagerEntity)localObject2).status == 16)) {
          break label312;
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (FileModel.a((FileManagerEntity)localObject2).a(false)) {
            j = 1;
          }
        }
        paramActivity.add(localObject1);
      }
      if (paramActivity.size() == 0)
      {
        FMToastUtil.a(2131428332);
        return false;
      }
      if (i != 0) {
        FMDialogUtil.a(BaseActivity.sTopActivity, 2131428241, 2131428237, new amrb(paramActivity, paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt));
      }
    }
    while (bool)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131428195, 0).b(paramInt);
      return true;
      paramActivity = paramActivity.iterator();
      for (bool = false; paramActivity.hasNext(); bool = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramActivity.next(), BaseActivity.sTopActivity, true)) {}
      bool |= a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler);
      continue;
      bool = a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler);
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131428207, 0).b(paramInt);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, MqqHandler paramMqqHandler)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
    if (!NetworkUtil.d(paramActivity))
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131432992, 0).b(paramInt);
      return false;
    }
    List localList = MultiMsgManager.a().a();
    if (localList.size() == 0)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131433406, 0).b(paramInt);
      return false;
    }
    if (localList.size() == 1) {
      return b(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
    }
    return a(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, MqqHandler paramMqqHandler)
  {
    if (((paramArrayList1 != null) && (paramArrayList1.size() > 0)) || ((paramArrayList2 != null) && (paramArrayList2.size() > 0)) || ((paramArrayList3 != null) && (paramArrayList3.size() > 0)))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramArrayList3 != null) && (paramArrayList3.size() > 0))
      {
        paramArrayList3 = paramArrayList3.iterator();
        label58:
        if (paramArrayList3.hasNext())
        {
          Iterator localIterator = ((StructMsgForImageShare)paramArrayList3.next()).mStructMsgItemLists.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label58;
            }
            Object localObject1 = (AbsStructMsgElement)localIterator.next();
            if (!AbsStructMsgItem.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = ((AbsStructMsgItem)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
              if (StructMsgItemImage.class.isInstance(localObject2))
              {
                localObject2 = (StructMsgItemImage)localObject2;
                if (!a(((StructMsgItemImage)localObject2).a)) {
                  localArrayList.add(((StructMsgItemImage)localObject2).a);
                }
              }
            }
          }
        }
      }
      if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
      {
        paramArrayList1 = paramArrayList1.iterator();
        while (paramArrayList1.hasNext())
        {
          paramArrayList3 = (MessageForPic)paramArrayList1.next();
          if (!a(paramArrayList3)) {
            localArrayList.add(paramArrayList3);
          }
        }
      }
      if ((localArrayList.size() == 0) && ((paramArrayList2 == null) || (paramArrayList2.size() == 0))) {
        return false;
      }
      paramQQAppInterface.a().a().a(localArrayList, paramArrayList2, new amre(paramMqqHandler));
      return true;
    }
    return false;
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    return (HotChatHelper.a(paramChatMessage)) || (FlashPicHelper.a(paramChatMessage));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List paramList, MqqHandler paramMqqHandler)
  {
    paramList = (ChatMessage)paramList.get(0);
    ResponseHandler.a(paramList.frienduin, paramList.senderuin, paramList.istroop);
    if ((paramList instanceof MessageForTroopFile)) {
      TroopFileUtils.a(paramActivity, paramQQAppInterface, paramList);
    }
    for (;;)
    {
      return true;
      if ((paramList instanceof MessageForFile))
      {
        paramActivity = FileManagerUtil.a(paramQQAppInterface, (MessageForFile)paramList);
        if (paramActivity.cloudType == 0)
        {
          FMToastUtil.a(2131428332);
          return false;
        }
        if (paramActivity.status == 16)
        {
          FMToastUtil.a(2131428188);
          return false;
        }
        if (FileModel.a((MessageForFile)paramList).a(false)) {
          FMDialogUtil.a(BaseActivity.sTopActivity, 2131428241, 2131428238, new amrc(paramQQAppInterface, paramList));
        } else {
          FileManagerUtil.a(paramQQAppInterface, paramList, BaseActivity.sTopActivity);
        }
      }
      else if (((paramList instanceof MessageForPic)) || ((paramList instanceof MessageForShortVideo)))
      {
        if (a(paramList))
        {
          FMToastUtil.a(2131428332);
          return false;
        }
        paramQQAppInterface.a().a().a(paramList, new amre(paramMqqHandler));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ThreadManager.getUIHandler().post(new amrd(paramQQAppInterface, paramInt));
        } else {
          QQToast.a(paramQQAppInterface.getApp(), 2131428195, 0).b(paramInt);
        }
      }
      else
      {
        if (!MultiMsgProxy.c(paramList)) {
          break;
        }
        paramList = (StructMsgForImageShare)((MessageForStructing)paramList).structingMsg;
        paramActivity = new ArrayList();
        paramList = paramList.mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (AbsStructMsgElement)paramList.next();
          if (AbsStructMsgItem.class.isInstance(localObject1))
          {
            localObject1 = ((AbsStructMsgItem)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
              if (StructMsgItemImage.class.isInstance(localObject2))
              {
                localObject2 = (StructMsgItemImage)localObject2;
                if (!a(((StructMsgItemImage)localObject2).a)) {
                  paramActivity.add(((StructMsgItemImage)localObject2).a);
                }
              }
            }
          }
        }
        if (paramActivity.size() > 0)
        {
          a(paramQQAppInterface, paramActivity, null, null, paramMqqHandler);
          QQToast.a(paramQQAppInterface.getApp(), 2131428195, 0).b(paramInt);
        }
        else
        {
          QQToast.a(paramQQAppInterface.getApp(), 2131428207, 0).b(paramInt);
        }
      }
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131428207, 0).b(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.weiyun.WeiyunAIOUtils
 * JD-Core Version:    0.7.0.1
 */