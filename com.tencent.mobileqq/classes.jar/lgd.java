import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.av.ui.funchat.zimu.ZimuToolbar;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Observable;

public class lgd
{
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private lge jdField_a_of_type_Lge;
  
  public lgd(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Lge = new lge(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Lge);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    int i = 0;
    while (i < 15)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i).a(paramString, paramBoolean);
      }
      i += 1;
    }
  }
  
  private void a(Observable paramObservable, Object paramObject)
  {
    paramObservable = (Object[])paramObject;
    switch (((Integer)paramObservable[0]).intValue())
    {
    default: 
    case 101: 
    case 6009: 
    case 6103: 
    case 13: 
    case 203: 
      long l1;
      do
      {
        return;
        a(mtl.a(paramObservable, 1), 2, null);
        return;
        b(((Integer)paramObservable[1]).intValue(), (String)paramObservable[2]);
        return;
        a(((Integer)paramObservable[1]).intValue(), (String)paramObservable[2]);
        return;
        l1 = mtl.a(paramObservable, 1);
        if (QLog.isColorLevel()) {
          QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[Connected],");
        }
        a(l1, 1, null);
        return;
        paramObject = (String)paramObservable[1];
        bool = ((Boolean)paramObservable[2]).booleanValue();
        l1 = mtl.a(paramObservable, 3);
        paramObservable = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d;
        long l2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().g;
        QLog.w("BusinessMessageCenter", 1, "onSessionStatusChanged[END], eventPeerUin[" + paramObject + "], isQuit[" + bool + "], curPeerUin[" + paramObservable + "], relationId[" + l2 + "]");
      } while ((paramObservable != null) && (!paramObservable.equalsIgnoreCase(paramObject)));
      a(l1, 3, null);
      return;
    }
    paramObject = (String)paramObservable[1];
    boolean bool = ((Boolean)paramObservable[2]).booleanValue();
    paramObservable = paramObject;
    if (TextUtils.isEmpty(paramObject)) {
      paramObservable = "";
    }
    a(paramObservable, bool);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (((paramInt == 3) || (paramInt == 1)) && (!((lhz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(3, paramInt, paramString))) {
      ((lgp)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3)).a(paramInt, paramString);
    }
    return 0;
  }
  
  public int a(String paramString)
  {
    Object localObject;
    String str1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = paramString.split("\\|");
      str1 = null;
      if (localObject.length <= 0) {
        break label677;
      }
    }
    label650:
    label655:
    label660:
    label677:
    for (lip locallip = localObject[0];; locallip = null)
    {
      if (locallip == null) {
        return 0;
      }
      if (localObject.length > 1) {
        str1 = localObject[1];
      }
      if (localObject.length > 2) {}
      for (String str2 = localObject[2];; str2 = null)
      {
        if (localObject.length > 3) {}
        for (long l1 = AudioHelper.a(localObject[3]);; l1 = 0L)
        {
          long l2 = AudioHelper.a();
          long l3 = AudioHelper.b();
          int i;
          if (locallip.startsWith("EMPTY_ITEM"))
          {
            if (!ZimuToolbar.isSupport()) {
              break;
            }
            locallip = (lip)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
            localObject = (ZimuItem)locallip.a();
            if ((localObject == null) || (TextUtils.isEmpty(((ZimuItem)localObject).getId()))) {
              break label660;
            }
            QLog.w("BusinessMessageCenter", 1, "onReceivedChangingZimuOfPeer, 对方取消字幕, info[" + paramString + "], sessionid[" + str1 + "], cmdSeq[" + str2 + "], seq[" + l3 + "], sendTime[" + l1 + "], offset[" + (l2 - l1) + "], isTranslation[" + locallip.c() + "], cur[" + ((ZimuItem)localObject).getId() + "]");
            paramString = (lip)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
            paramString.a("onReceivedChangingZimuOfPeer", l3);
            new mcd(l3, "onReceivedChangingZimuOfPeer", 3, "0").a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
            paramString.a(l3, null);
            i = 1;
            a(Integer.valueOf(6010), Integer.valueOf(1));
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(0);
            return i;
            if (!ZimuToolbar.isSupport()) {
              break;
            }
            localObject = (lip)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(0);
            ZimuItem localZimuItem1 = (ZimuItem)((lip)localObject).a(locallip);
            ZimuItem localZimuItem2 = (ZimuItem)((lip)localObject).a();
            QLog.w("BusinessMessageCenter", 1, "onReceivedChangingZimuOfPeer, 对方选择字幕, info[" + paramString + "], zimuId[" + locallip + "], sessionid[" + str1 + "], cmdSeq[" + str2 + "], seq[" + l3 + "], sendTime[" + l1 + "], offset[" + (l2 - l1) + "], isTranslation[" + ((lip)localObject).c() + "], ZimuItem[" + localZimuItem1 + "], CurItem[" + localZimuItem2 + "]");
            boolean bool;
            if (localZimuItem1 != null) {
              if (localZimuItem2 == null)
              {
                bool = false;
                if (bool) {
                  break label655;
                }
                ((lip)localObject).a("onReceivedChangingZimuOfPeer", false, l3, str1);
                ((lip)localObject).a(l3, locallip);
                if (!localZimuItem1.isUsable()) {
                  ((lip)localObject).a(l3, localZimuItem1);
                }
                new mcd(l3, "onReceivedChangingZimuOfPeer", 1, locallip).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
                if (localZimuItem2 != null) {
                  break label650;
                }
                i = 3;
                label580:
                a(Integer.valueOf(6010), Integer.valueOf(i));
                j = i;
                if (!ZimuToolbar.isShow(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
                  a(Integer.valueOf(6012), Integer.valueOf(i));
                }
              }
            }
            for (int j = i;; j = 0)
            {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.c(0);
              return j;
              bool = localZimuItem2.getId().equalsIgnoreCase(localZimuItem1.getId());
              break;
              i = 2;
              break label580;
            }
            i = 0;
          }
        }
      }
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    String str = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().f() + "";
    int i = 0;
    while (i < 15)
    {
      if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i)) {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i).a(paramLong, paramInt, str, paramString);
      }
      i += 1;
    }
  }
  
  protected void a(Integer paramInteger, Object paramObject)
  {
    lbc.c("BusinessMessageCenter", "notifyEvent :" + paramInteger + "|" + paramObject);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { paramInteger, paramObject });
  }
  
  public int b(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return 0;
      } while (((lhz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(0, paramInt, paramString));
      a(paramString);
      return 0;
    } while (((lhz)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5)).a(0, paramInt, paramString));
    String str = paramString;
    if (paramString.equals("。")) {
      str = "。 ";
    }
    paramString = new lga(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d, str, str, 2);
    paramString.a = true;
    a(Integer.valueOf(6008), paramString);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lgd
 * JD-Core Version:    0.7.0.1
 */