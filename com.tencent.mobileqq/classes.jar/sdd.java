import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sdd
{
  public int a;
  public long a;
  public String a;
  protected WeakReference<QQAppInterface> a;
  public List<sde> a;
  public int b;
  public WeakReference<MessageRecord> b;
  
  public sdd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static sdd a(QQAppInterface paramQQAppInterface, Context paramContext, TroopBarData paramTroopBarData)
  {
    Object localObject3 = paramTroopBarData.mLatestMessage;
    Object localObject2 = localObject3;
    if (localObject3 == null)
    {
      localObject2 = paramQQAppInterface.a().a(paramTroopBarData.mUin, 1008);
      localObject1 = localObject3;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if ((localObject2 instanceof MessageRecord)) {
          localObject1 = localObject2;
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        return null;
      }
    }
    Object localObject1 = new sdd(paramQQAppInterface);
    localObject3 = paramQQAppInterface.a();
    if (localObject3 != null) {}
    for (int i = ((akpc)localObject3).a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop);; i = 0)
    {
      long l;
      if (paramTroopBarData.mLastMsgTime > paramTroopBarData.mLastDraftTime)
      {
        l = paramTroopBarData.mLastMsgTime;
        ((sdd)localObject1).jdField_a_of_type_Long = l;
        ((sdd)localObject1).jdField_a_of_type_JavaLangString = ((MessageRecord)localObject2).frienduin;
        ((sdd)localObject1).jdField_b_of_type_Int = i;
        try
        {
          if ((localObject2 instanceof MessageForPubAccount))
          {
            ((MessageForPubAccount)localObject2).parse();
            ((sdd)localObject1).jdField_a_of_type_Int = 1;
            paramQQAppInterface = ((MessageForPubAccount)localObject2).mPAMessage;
            if (paramQQAppInterface != null)
            {
              paramQQAppInterface = paramQQAppInterface.items.iterator();
              while (paramQQAppInterface.hasNext())
              {
                paramContext = (PAMessage.Item)paramQQAppInterface.next();
                paramTroopBarData = new sde();
                paramTroopBarData.jdField_a_of_type_Int = 1;
                paramTroopBarData.jdField_a_of_type_JavaLangString = paramContext.cover;
                paramTroopBarData.d = paramContext.url;
                paramTroopBarData.e = paramContext.actionData;
                paramTroopBarData.b = paramContext.title;
                ((sdd)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
              }
            }
            ((sdd)localObject1).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localObject2);
          }
        }
        catch (Exception paramQQAppInterface)
        {
          ((sdd)localObject1).jdField_a_of_type_Int = 0;
          paramContext = new sde();
          paramContext.jdField_a_of_type_Int = 0;
          paramContext.c = ((MessageRecord)localObject2).msg;
          ((sdd)localObject1).jdField_a_of_type_JavaUtilList.clear();
          ((sdd)localObject1).jdField_a_of_type_JavaUtilList.add(paramContext);
          if (QLog.isColorLevel()) {
            QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed exception: ", paramQQAppInterface);
          }
        }
      }
      for (;;)
      {
        return localObject1;
        l = paramTroopBarData.mLastDraftTime;
        break;
        if ((localObject2 instanceof MessageForStructing))
        {
          ((MessageForStructing)localObject2).parse();
          ((sdd)localObject1).jdField_a_of_type_Int = 1;
          paramContext = ((MessageForStructing)localObject2).structingMsg;
          if ((paramContext != null) && ((paramContext instanceof AbsShareMsg)))
          {
            paramQQAppInterface = ((AbsShareMsg)paramContext).getStructMsgItemLists();
            if ((QLog.isColorLevel()) && ((paramQQAppInterface == null) || (paramQQAppInterface.isEmpty()))) {
              QLog.w("SubscriptionFeed", 2, "convertMsgToSubscriptionFeed MessageForStructing itemlist size = 0");
            }
            paramTroopBarData = paramQQAppInterface.iterator();
            label800:
            label809:
            label816:
            for (;;)
            {
              label443:
              sde localsde;
              if (paramTroopBarData.hasNext())
              {
                localObject3 = (axun)paramTroopBarData.next();
                localsde = new sde();
                localsde.jdField_a_of_type_Int = 1;
                localsde.c = ((axun)localObject3).g;
                localsde.g = paramContext.mTagName;
                if (!(localObject3 instanceof axuo)) {
                  break label809;
                }
                paramQQAppInterface = ((axuo)localObject3).a.iterator();
                for (;;)
                {
                  if (!paramQQAppInterface.hasNext()) {
                    break label726;
                  }
                  Object localObject4 = (axun)paramQQAppInterface.next();
                  if ((localObject4 instanceof axwq))
                  {
                    localsde.jdField_a_of_type_JavaLangString = ((axwq)localObject4).S;
                  }
                  else if ((localObject4 instanceof StructMsgItemTitle))
                  {
                    localsde.b = ((StructMsgItemTitle)localObject4).b();
                  }
                  else if ((localObject4 instanceof axzq))
                  {
                    localsde.jdField_a_of_type_JavaLangString = ((axzq)localObject4).S;
                  }
                  else if ((localObject4 instanceof axyw))
                  {
                    localsde.jdField_a_of_type_JavaLangString = ((axyw)localObject4).S;
                  }
                  else if ((localObject4 instanceof axzb))
                  {
                    localsde.jdField_a_of_type_JavaLangString = ((axzb)localObject4).S;
                  }
                  else if ((localObject4 instanceof axvq))
                  {
                    localObject4 = ((axvq)localObject4).jdField_a_of_type_JavaUtilList.iterator();
                    if (((Iterator)localObject4).hasNext())
                    {
                      axun localaxun = (axun)((Iterator)localObject4).next();
                      if (!(localaxun instanceof StructMsgItemTitle)) {
                        break;
                      }
                      localsde.b = ((StructMsgItemTitle)localaxun).b();
                    }
                  }
                }
                label726:
                if (!TextUtils.isEmpty(((axun)localObject3).b)) {
                  break label800;
                }
                paramQQAppInterface = paramContext.mMsgUrl;
                label742:
                localsde.d = paramQQAppInterface;
              }
              for (;;)
              {
                if ((((axuo)localObject3).a.size() == 1) && (((axun)((axuo)localObject3).a.get(0) instanceof axws))) {
                  break label816;
                }
                ((sdd)localObject1).jdField_a_of_type_JavaUtilList.add(localsde);
                break label443;
                break;
                paramQQAppInterface = ((axun)localObject3).b;
                break label742;
                localsde.jdField_a_of_type_Int = 0;
              }
            }
          }
        }
        else
        {
          if (!(localObject2 instanceof MessageForPic)) {
            break label911;
          }
          ((MessageForPic)localObject2).parse();
          ((sdd)localObject1).jdField_a_of_type_Int = 3;
          paramTroopBarData = new sde();
          paramTroopBarData.jdField_a_of_type_Int = 2;
          paramTroopBarData.c = paramQQAppInterface.a().b(paramContext, (MessageRecord)localObject2, false);
          paramTroopBarData.f = ((MessageForPic)localObject2).path;
          paramTroopBarData.jdField_a_of_type_JavaNetURL = aywk.a((MessageForPic)localObject2, 65537, null);
          ((sdd)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        }
      }
      label911:
      if ((localObject2 instanceof MessageForText))
      {
        ((sdd)localObject1).jdField_a_of_type_Int = 0;
        ((MessageForText)localObject2).parse();
      }
      for (;;)
      {
        paramTroopBarData = new sde();
        paramTroopBarData.jdField_a_of_type_Int = 0;
        paramTroopBarData.c = paramQQAppInterface.a().b(paramContext, (MessageRecord)localObject2, false);
        ((sdd)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopBarData);
        break;
        if ((localObject2 instanceof MessageForVideo))
        {
          ((sdd)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForShortVideo))
        {
          ((sdd)localObject1).jdField_a_of_type_Int = 2;
          ((MessageForShortVideo)localObject2).parse();
        }
        else if ((localObject2 instanceof MessageForPtt))
        {
          ((sdd)localObject1).jdField_a_of_type_Int = 4;
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null)) {}
    QQMessageFacade.Message localMessage;
    Object localObject;
    do
    {
      do
      {
        return;
        localMessage = null;
        int i = sgj.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_JavaLangString);
        localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
        if (localObject != null) {
          localMessage = ((QQMessageFacade)localObject).a(this.jdField_a_of_type_JavaLangString, i);
        }
      } while (localMessage == null);
      this.jdField_b_of_type_Int = 0;
      sdf.a().a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMessage.frienduin);
      localObject = ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a();
    } while (localObject == null);
    ((akpc)localObject).a(localMessage.frienduin, localMessage.istroop, true);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (sdd)paramObject;
      if (this.jdField_a_of_type_JavaLangString != null) {
        return this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
    } while (paramObject.jdField_a_of_type_JavaLangString == null);
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      return this.jdField_a_of_type_JavaLangString.hashCode();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdd
 * JD-Core Version:    0.7.0.1
 */