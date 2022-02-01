import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenDialogActivity;
import com.tencent.av.wtogether.WTogetherMng.2;
import com.tencent.av.wtogether.WTogetherMng.3;
import com.tencent.av.wtogether.data.ChooseFileInfo;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.data.WTFileInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import trpc.qq_av_together.common.WTogetherCommon.PushMsg;
import trpc.qq_av_together.common.WTogetherCommon.RoomInfo;

public class mxd
  extends lgp
  implements Handler.Callback
{
  private final bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private final ConcurrentHashMap<String, myx> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(2);
  
  public mxd(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private lfe a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    Object localObject = null;
    if (paramInt == 2) {
      paramInt = 3;
    }
    for (paramString = String.valueOf(paramLong2);; paramString = null)
    {
      String str = lbz.a(paramInt, paramString, new int[0]);
      paramString = lbz.a().a();
      if (!TextUtils.equals(paramString.jdField_c_of_type_JavaLangString, str)) {
        paramString = localObject;
      }
      for (;;)
      {
        if ((paramString != null) && (paramString.b() != paramLong1) && (QLog.isColorLevel())) {
          QLog.i("WTogether.Mng", 2, "getSessionInfo, [" + paramString.b() + "," + paramLong1 + "]");
        }
        return paramString;
      }
      paramInt = 0;
    }
  }
  
  private myx a(int paramInt, long paramLong)
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        myx localmyx = (myx)((Map.Entry)localIterator.next()).getValue();
        if ((localmyx != null) && (localmyx.b() == paramInt))
        {
          long l = localmyx.a();
          if (l == paramLong) {
            return localmyx;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
    return null;
  }
  
  private myx a(int paramInt, long paramLong1, long paramLong2, String paramString)
  {
    if (TextUtils.equals(String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, paramString + ", self receive start push. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
      localObject = null;
      return localObject;
    }
    Object localObject = a(paramInt, paramLong1, paramLong2, paramString);
    if ((localObject == null) || (((lfe)localObject).f()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, paramString + ", session is illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
      return null;
    }
    myr localmyr = new myr(paramInt, paramLong1, paramLong2, paramString);
    paramString = b((lfe)localObject);
    if (paramString == null) {
      paramString = a((lfe)localObject);
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      paramString.a(1, "getWatchTogetherInfoForPush");
      paramString.a(paramInt, paramLong1);
      return paramString;
      if (a(localmyr))
      {
        localObject = paramString.jdField_a_of_type_Myw;
        if ((localObject != null) && (((myw)localObject).a() == 1) && (((myw)localObject).b() == 1)) {
          paramString.jdField_a_of_type_Myr = localmyr;
        }
        for (;;)
        {
          paramString = null;
          break;
          if (localObject != null) {
            a(localmyr);
          }
        }
      }
    }
  }
  
  private myx a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    String str1 = lbz.a(paramInt, paramString, new int[0]);
    Object localObject = (myx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
    if ((localObject == null) && (paramBoolean)) {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        myx localmyx = (myx)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1);
        localObject = localmyx;
        if (localmyx == null)
        {
          localObject = new myx(str2, str1, paramInt, paramString);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str1, localObject);
        }
        return localObject;
      }
    }
    return localObject;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1, paramLong2, "onReceiveStartPush");
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label81;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceiveStartPush, illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
    }
    label81:
    do
    {
      return;
      localObject = ((myx)localObject).a();
      break;
      if (((myw)localObject).a() == 0)
      {
        ((myw)localObject).a(String.valueOf(paramLong2));
        b(a(paramInt, paramLong1));
        return;
      }
    } while (!TextUtils.equals(((myw)localObject).jdField_b_of_type_JavaLangString, String.valueOf(paramLong2)));
    a((myw)localObject, 6);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    myx localmyx = a(paramInt1, paramLong1);
    if ((localmyx != null) && (!TextUtils.equals(String.valueOf(paramLong2), this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin()))) {
      a(localmyx.a(), paramInt2);
    }
    if ((paramInt2 == 2) || (paramInt2 == 3)) {
      if (localmyx == null) {
        b((myw)localObject1, 2131695729);
      }
    }
    do
    {
      return;
      localObject1 = localmyx.jdField_a_of_type_Myw;
      break;
      if (paramInt2 == 4)
      {
        if (localmyx == null) {}
        for (localObject1 = localObject2;; localObject1 = localmyx.jdField_a_of_type_Myw)
        {
          b((myw)localObject1, 2131695727);
          return;
        }
      }
    } while (paramInt2 != 1);
    if (localmyx == null) {}
    for (localObject1 = localObject3;; localObject1 = localmyx.jdField_a_of_type_Myw)
    {
      b((myw)localObject1, 2131695743);
      return;
    }
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onReceiveUserEnterOrLeave, [roomType: " + paramInt + ", roomId: " + paramLong1 + ", operator: " + paramLong2 + ", seq: " + paramLong3 + ", enter: " + paramBoolean + "]");
    }
    myo localmyo = new myo(paramInt, paramLong1);
    localmyo.jdField_a_of_type_Boolean = paramBoolean;
    localmyo.jdField_a_of_type_JavaLangString = String.valueOf(paramLong2);
    mxc localmxc = (mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4);
    if (localmxc != null) {
      localmxc.notifyUI(10, localmyo.jdField_a_of_type_Boolean, localmyo);
    }
  }
  
  private void a(long paramLong, String paramString)
  {
    if (!this.jdField_a_of_type_Bkys.hasMessages(5))
    {
      Message localMessage = Message.obtain();
      localMessage.what = 5;
      this.jdField_a_of_type_Bkys.sendMessageDelayed(localMessage, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "tryEnterRoomLater, from[" + paramString + "]");
    }
  }
  
  private void a(String paramString)
  {
    if (!this.jdField_a_of_type_Bkys.hasMessages(1))
    {
      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(1, 10000L);
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "startSync, from[" + paramString + "]");
      }
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    paramString = new WTogetherMng.2(this, paramString);
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_Bkys.post(paramString);
      return;
    }
    this.jdField_a_of_type_Bkys.postDelayed(paramString, paramLong);
  }
  
  private void a(myo parammyo, myx parammyx, myw parammyw, String paramString)
  {
    if ((parammyo == null) || (parammyx == null) || (parammyw == null)) {}
    for (;;)
    {
      return;
      if ((!parammyo.jdField_a_of_type_Boolean) && (parammyo.jdField_b_of_type_Int == 1009)) {
        a(parammyx, 7, "checkError");
      }
      while ((!parammyo.jdField_a_of_type_Boolean) && (QLog.isColorLevel()))
      {
        QLog.i("WTogether.Mng", 2, "checkError, errCode[" + parammyo.jdField_b_of_type_Int + "], from[" + paramString + "]");
        return;
        if ((!parammyo.jdField_a_of_type_Boolean) && (parammyo.jdField_b_of_type_Int == 1007)) {
          a(parammyx, 5, "checkError");
        }
      }
    }
  }
  
  private void a(myr parammyr)
  {
    if (parammyr == null) {}
    do
    {
      do
      {
        do
        {
          return;
          parammyr = a(parammyr.jdField_a_of_type_Int, parammyr.jdField_a_of_type_Long, parammyr.jdField_b_of_type_Long, "dealForRoomIdConflict");
        } while (parammyr == null);
        parammyr = b(parammyr);
      } while ((parammyr == null) || (parammyr.jdField_a_of_type_Myw == null));
      a(parammyr, 6, "dealForRoomIdConflict");
      a(BaseApplicationImpl.getContext().getString(2131695751), 100L);
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "dealForRoomIdConflict");
  }
  
  private void a(myw parammyw)
  {
    if (parammyw == null) {}
    for (myv localmyv = null; (localmyv == null) || (!localmyv.a()) || (parammyw.a() != 3); localmyv = parammyw.jdField_a_of_type_Myv)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onMsgOnChangeFile, illegal param, room[" + parammyw + "]");
      }
      return;
    }
    parammyw = new mys(parammyw.jdField_a_of_type_Int, parammyw.jdField_b_of_type_Long, 0, localmyv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo, 1, true);
    parammyw.jdField_a_of_type_JavaLangString = localmyv.jdField_a_of_type_Myu.jdField_b_of_type_JavaLangString;
    parammyw.jdField_b_of_type_JavaLangString = localmyv.jdField_a_of_type_Myu.jdField_c_of_type_JavaLangString;
    parammyw.jdField_c_of_type_Boolean = true;
    parammyw.d = 0;
    parammyw.jdField_c_of_type_JavaLangString = null;
    a(parammyw);
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).notifyUI(1, true, parammyw);
  }
  
  private void a(myw parammyw, WTogetherCommon.RoomInfo paramRoomInfo, String paramString)
  {
    long l = 200L;
    if ((paramRoomInfo == null) || (parammyw == null)) {}
    for (;;)
    {
      return;
      boolean bool = parammyw.a(paramRoomInfo, paramString);
      paramRoomInfo = parammyw.jdField_a_of_type_Myv;
      if (paramRoomInfo == null) {}
      while ((bool) && (QLog.isColorLevel()))
      {
        QLog.i("WTogether.Mng", 2, "updateRoomInfo, from[" + paramString + "], room[" + parammyw + "]");
        return;
        if (paramRoomInfo.a())
        {
          if (bool)
          {
            parammyw.a(3, 2, paramString);
            paramRoomInfo = Message.obtain();
            paramRoomInfo.what = 3;
            paramRoomInfo.obj = parammyw;
            bkys localbkys = this.jdField_a_of_type_Bkys;
            if (parammyw.e()) {
              l = 50L;
            }
            localbkys.sendMessageDelayed(paramRoomInfo, l);
          }
          else if ((parammyw.a() == 3) && (parammyw.b() != 2))
          {
            parammyw.a(3, 2, paramString);
          }
        }
        else if (paramRoomInfo.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_Int == 0)
        {
          parammyw.a(3, 1, paramString);
          parammyw.jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_b_of_type_Int = ((int)AudioHelper.b());
          ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(parammyw.jdField_a_of_type_Int, parammyw.jdField_b_of_type_Long, parammyw.jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_b_of_type_Int, parammyw.jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo, true, 0);
        }
        else if (bool)
        {
          parammyw.a(3, 3, paramString);
          a(BaseApplicationImpl.getApplication().getString(2131695726), 200L);
        }
      }
    }
  }
  
  private void a(myx parammyx, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "quitWatchTogether, reason[" + paramInt + "], from[" + paramString + "]");
    }
    if (parammyx == null) {}
    for (paramString = null; paramString == null; paramString = parammyx.jdField_a_of_type_Myw)
    {
      d(parammyx);
      return;
    }
    parammyx.jdField_b_of_type_Int = paramInt;
    if (paramString.e())
    {
      a(parammyx);
      return;
    }
    c(parammyx);
  }
  
  private void a(myx parammyx, String paramString)
  {
    Object localObject2 = null;
    if (parammyx == null) {}
    for (Object localObject1 = null; (localObject1 == null) || (!((myw)localObject1).e()); localObject1 = parammyx.jdField_a_of_type_Myw) {
      return;
    }
    if (parammyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo != null) {
      if (parammyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_Int == 0)
      {
        parammyx.jdField_c_of_type_Int = 4;
        label51:
        if (((myw)localObject1).jdField_a_of_type_Myv != null) {
          break label166;
        }
      }
    }
    label166:
    for (localObject1 = localObject2;; localObject1 = ((myw)localObject1).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo)
    {
      if ((localObject1 != null) && (((WTFileInfo)localObject1).jdField_a_of_type_Int == 0)) {
        ((WTFileInfo)localObject1).jdField_c_of_type_Int = parammyx.jdField_c_of_type_Int;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 2, "updateWTFileInfoVideoSrcTypeExtra, from[" + paramString + "], videoSrcTypeExtra[" + parammyx.jdField_c_of_type_Int + "]");
      return;
      if (parammyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo.jdField_a_of_type_Int == 1)
      {
        parammyx.jdField_c_of_type_Int = 3;
        break label51;
      }
      parammyx.jdField_c_of_type_Int = 0;
      break label51;
      parammyx.jdField_c_of_type_Int = 0;
      break label51;
    }
  }
  
  private void a(WTogetherCommon.PushMsg paramPushMsg)
  {
    if (paramPushMsg == null) {
      return;
    }
    int i = paramPushMsg.room_type.get();
    long l1 = paramPushMsg.room_id.get();
    long l2 = paramPushMsg.operate_uin.get();
    long l3 = paramPushMsg.seq.get();
    int j = paramPushMsg.action_type.get();
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onQavPushMsg, [roomType: " + i + ", roomId: " + l1 + ", operator: " + l2 + ", action: " + j + ", seq: " + l3 + "]");
    }
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      a(i, l1, l2, l3, j);
      return;
    case 6: 
      a(i, l1, l2);
      return;
    case 7: 
      b(i, l1, l2);
      return;
    case 8: 
      c(i, l1, l2);
      return;
    case 9: 
    case 10: 
      if (j == 9) {}
      for (boolean bool = true;; bool = false)
      {
        a(i, l1, l2, l3, bool);
        return;
      }
    }
    d(i, l1, l2);
  }
  
  public static boolean a(VideoAppInterface paramVideoAppInterface)
  {
    lfe locallfe = lbz.a().a();
    if (paramVideoAppInterface != null) {}
    for (paramVideoAppInterface = (mxd)paramVideoAppInterface.a(15);; paramVideoAppInterface = null)
    {
      if (paramVideoAppInterface == null)
      {
        paramVideoAppInterface = null;
        if (paramVideoAppInterface != null) {
          break label55;
        }
      }
      label55:
      for (paramVideoAppInterface = null;; paramVideoAppInterface = paramVideoAppInterface.jdField_a_of_type_Myw)
      {
        if ((paramVideoAppInterface == null) || (paramVideoAppInterface.a() == 0)) {
          break label63;
        }
        return true;
        paramVideoAppInterface = paramVideoAppInterface.b(locallfe);
        break;
      }
      label63:
      return false;
    }
  }
  
  private boolean a(myr parammyr)
  {
    if (parammyr == null) {}
    lfe locallfe;
    myx localmyx;
    myw localmyw;
    do
    {
      do
      {
        do
        {
          return false;
          locallfe = a(parammyr.jdField_a_of_type_Int, parammyr.jdField_a_of_type_Long, parammyr.jdField_b_of_type_Long, parammyr.jdField_a_of_type_JavaLangString);
        } while (locallfe == null);
        localmyx = b(locallfe);
      } while (localmyx == null);
      localmyw = localmyx.jdField_a_of_type_Myw;
    } while ((localmyw == null) || (localmyw.a() == 0));
    long l1 = localmyx.a();
    int i = localmyx.b();
    long l2 = locallfe.b();
    if ((localmyw.e()) && (l1 == l2) && (l1 != 0L) && ((l1 != parammyr.jdField_a_of_type_Long) || (i != parammyr.jdField_a_of_type_Int))) {}
    for (boolean bool = true;; bool = false)
    {
      if ((QLog.isColorLevel()) && (bool)) {
        QLog.i("WTogether.Mng", 2, "checkRoomIdConflict, error. come[" + parammyr.jdField_a_of_type_Int + "," + parammyr.jdField_a_of_type_Long + "," + parammyr.jdField_b_of_type_Long + "], cur[" + i + "," + l1 + "," + localmyw.jdField_b_of_type_JavaLangString + "]");
      }
      return bool;
    }
  }
  
  private void b()
  {
    Object localObject = lbz.a().a();
    if ((localObject == null) || (((lfe)localObject).f())) {}
    for (;;)
    {
      return;
      localObject = b((lfe)localObject);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (((myw)localObject).a() == 4); localObject = ((myx)localObject).jdField_a_of_type_Myw)
      {
        ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(((myw)localObject).jdField_a_of_type_Int, ((myw)localObject).jdField_b_of_type_Long, ((myw)localObject).jdField_a_of_type_Long, ((myw)localObject).jdField_a_of_type_Myt);
        this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(1, 10000L);
        return;
      }
    }
  }
  
  private void b(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1);
    if (localObject == null) {}
    for (myw localmyw = null; localmyw == null; localmyw = ((myx)localObject).jdField_a_of_type_Myw) {
      return;
    }
    ((myx)localObject).jdField_b_of_type_Int = 2;
    if (localmyw.e())
    {
      a((myx)localObject);
      return;
    }
    localmyw.a(5, 1, "onReceiveClosePush");
    localObject = new myo(localmyw.jdField_a_of_type_Int, localmyw.jdField_b_of_type_Long);
    b((myo)localObject);
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).notifyUI(8, ((myo)localObject).jdField_a_of_type_Boolean, localObject);
    b(localmyw, 2131695730);
  }
  
  private void b(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onMsgClearInfo, info[" + paramString + "]");
    }
    if (paramString == null) {
      return;
    }
    d(paramString);
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_Bkys.hasMessages(1))
    {
      this.jdField_a_of_type_Bkys.removeMessages(1);
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "stopSync, from[" + paramString + "]");
      }
    }
  }
  
  private void b(myw parammyw, int paramInt)
  {
    if (parammyw == null) {
      return;
    }
    a(BaseApplicationImpl.getContext().getString(paramInt, new Object[] { parammyw.jdField_c_of_type_JavaLangString }), 300L);
  }
  
  public static boolean b(String paramString)
  {
    int i = 0;
    VideoController localVideoController = VideoController.a();
    int j;
    boolean bool;
    if ((!TextUtils.isEmpty(paramString)) && (localVideoController != null))
    {
      i = localVideoController.c(paramString);
      j = localVideoController.b(paramString);
      if ((i >= 126) && ((j == 4) || (j == 2) || (j == 3))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "isPeerSupportWT, uin[" + paramString + "], sdk[" + i + "], terminal[" + j + "], support[" + bool + "]");
      }
      return bool;
      bool = false;
      continue;
      j = 0;
      bool = false;
    }
  }
  
  private void c(int paramInt, long paramLong1, long paramLong2)
  {
    Object localObject = a(paramInt, paramLong1, paramLong2, "onReceiveChangeFilePush");
    if ((localObject == null) || (!((myx)localObject).a())) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceiveChangeFilePush, illegal. [roomType: " + paramInt + ", roomId: " + paramLong1 + "]");
      }
    }
    do
    {
      return;
      localObject = ((myx)localObject).a();
      if ((localObject != null) && (((myw)localObject).a() == 0))
      {
        ((myw)localObject).a(String.valueOf(paramLong2));
        b(a(paramInt, paramLong1));
        return;
      }
    } while ((localObject == null) || (!TextUtils.equals(((myw)localObject).jdField_b_of_type_JavaLangString, String.valueOf(paramLong2))));
    a((myw)localObject, 8);
    b((myw)localObject, 2131695725);
  }
  
  private void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "updateAVSDKWTogetherFlag, flag[" + paramInt + "], from[" + paramString + "]");
    }
    paramString = VideoController.a().a();
    if (paramString != null) {
      paramString.a(lbz.a().a().d, paramInt, true);
    }
  }
  
  private void d(int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onReceiveSecurityInfo");
    }
    myx localmyx = a(paramInt, paramLong1);
    if (localmyx == null) {}
    for (Object localObject = null; localObject == null; localObject = localmyx.jdField_a_of_type_Myw) {
      return;
    }
    localmyx.jdField_b_of_type_Int = 8;
    if (((myw)localObject).e()) {
      a(localmyx);
    }
    for (;;)
    {
      VideoController.a().jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(10007) });
      return;
      ((myw)localObject).a(5, 1, "onReceiveClosePush");
      localObject = new myo(((myw)localObject).jdField_a_of_type_Int, ((myw)localObject).jdField_b_of_type_Long);
      b((myo)localObject);
      ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).notifyUI(8, ((myo)localObject).jdField_a_of_type_Boolean, localObject);
    }
  }
  
  private void d(myx parammyx)
  {
    int i = 1;
    if (parammyx == null) {
      return;
    }
    String str = parammyx.jdField_b_of_type_JavaLangString;
    ??? = lbz.a().c(str);
    if ((??? == null) || (((lfe)???).f())) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        i = 0;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "clearInfo, ret[" + i + "], info[" + parammyx + "]");
        return;
      }
      if ((parammyx.a() == 0L) || (((lfe)???).b() == parammyx.a())) {
        synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
      }
      parammyx.a((lfe)???, true);
      i = 2;
    }
  }
  
  private void e(myx parammyx)
  {
    boolean bool2 = true;
    if (this.jdField_a_of_type_Bkys.hasMessages(6)) {
      this.jdField_a_of_type_Bkys.removeMessages(6);
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (parammyx != null) {
        if (parammyx.jdField_a_of_type_Myr != null)
        {
          bool1 = bool2;
          parammyx.jdField_a_of_type_Myr = null;
        }
      }
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("WTogether.Mng", 2, "clearConflictInfo, hasConflict[" + bool1 + "]");
        }
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public myv a(lfe paramlfe)
  {
    Object localObject = null;
    myx localmyx = b(paramlfe);
    paramlfe = localObject;
    if (localmyx != null)
    {
      paramlfe = localObject;
      if (localmyx.jdField_a_of_type_Myw != null) {
        paramlfe = localmyx.jdField_a_of_type_Myw.jdField_a_of_type_Myv;
      }
    }
    return paramlfe;
  }
  
  public myx a(lfe paramlfe)
  {
    if (paramlfe == null) {
      return null;
    }
    return a(paramlfe.f(), paramlfe.b(), true);
  }
  
  protected void a() {}
  
  public void a(int paramInt, String paramString)
  {
    myx localmyx = a(paramInt, paramString, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "clearForClose, [relationType: " + paramInt + ", relationId: " + paramString + ", info: " + localmyx + "]");
    }
    e(localmyx);
    a(localmyx, 3, "clearForClose");
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = true;
    if (paramInt2 == 1) {}
    for (;;)
    {
      myx localmyx = a(paramInt1, paramString, bool);
      if (localmyx != null) {
        localmyx.a(paramInt2, "updateFlg");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updateFlag, [relationType: " + paramInt1 + ", relationId: " + paramString + ", flag: " + paramInt2 + "]");
      }
      return;
      bool = false;
    }
  }
  
  public void a(int paramInt, String paramString, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    myx localmyx = a(paramInt, paramString, true);
    if (localmyx != null)
    {
      if (paramInt != 3) {
        break label149;
      }
      localmyx.jdField_a_of_type_JavaUtilArrayList.clear();
      localmyx.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(mrr.a(paramString)));
    }
    for (;;)
    {
      localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      if (paramChooseFileInfo != null) {
        localmyx.a(1, "updateChooseFile");
      }
      if (paramChooseFileInfo != null) {
        mrr.a("0X800B62A", paramChooseFileInfo.a(), 0, "", "", paramChooseFileInfo.a(), paramChooseFileInfo.b());
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updateChooseFile, [relationType: " + paramInt + ", relationId: " + paramString + ", file: " + paramChooseFileInfo + "]");
      }
      return;
      label149:
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        localmyx.jdField_a_of_type_JavaUtilArrayList.clear();
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          long l = paramArrayOfLong[i];
          localmyx.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
          i += 1;
        }
      }
    }
  }
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramInt != 4) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onReceivePushMsg, param illegal.");
      }
    }
    do
    {
      return;
      int j = 0;
      WTogetherCommon.PushMsg localPushMsg = new WTogetherCommon.PushMsg();
      try
      {
        localPushMsg.mergeFrom(paramArrayOfByte);
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
            i = j;
          }
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          int i = j;
          if (QLog.isColorLevel())
          {
            QLog.i("WTogether.Mng", 2, "onReceivePushMsg", paramArrayOfByte);
            i = j;
          }
        }
      }
    } while (i == 0);
    paramArrayOfByte = Message.obtain();
    paramArrayOfByte.what = 4;
    paramArrayOfByte.arg1 = paramInt;
    paramArrayOfByte.obj = localPushMsg;
    this.jdField_a_of_type_Bkys.sendMessage(paramArrayOfByte);
  }
  
  public void a(lfe paramlfe)
  {
    if (paramlfe == null) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onConnected, session is null.");
      }
    }
    for (;;)
    {
      return;
      myx localmyx = b(paramlfe);
      if ((localmyx == null) || (localmyx.a() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "onConnected, no info or flag is 0.");
        }
      }
      else
      {
        localmyx.a(paramlfe, true);
        Object localObject = localmyx.a();
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WTogether.Mng", 2, "onConnected, not valid to create room.");
          }
        }
        else
        {
          int i = ((myw)localObject).a();
          if ((i == 0) && (localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo != null)) {
            if (b(paramlfe.d))
            {
              localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
              ((mxk)localObject).b(new mxe(this, paramlfe, localmyx, (mxk)localObject));
            }
          }
          while (QLog.isDevelopLevel())
          {
            QLog.i("WTogether.Mng", 4, "onConnected, roomState[" + i + "], room[" + localmyx.jdField_a_of_type_Myw + "]");
            return;
            a(BaseApplicationImpl.getContext().getString(2131695744), 0L);
            continue;
            if (i == 0) {
              b(localmyx);
            }
          }
        }
      }
    }
  }
  
  public void a(lfe paramlfe, int paramInt, Intent paramIntent)
  {
    Object localObject = null;
    int i = -1;
    if ((paramInt == 4660) && (paramIntent != null))
    {
      paramIntent.setExtrasClassLoader(ChooseFileInfo.class.getClassLoader());
      localObject = (ChooseFileInfo)paramIntent.getParcelableExtra("ChooseFileInfo");
      paramInt = paramIntent.getIntExtra("watch_together_uinType", -1);
      String str = paramIntent.getStringExtra("watch_together_uin");
      paramIntent = (Intent)localObject;
      localObject = str;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onActivityResult, uinType[" + paramInt + "], uin[" + (String)localObject + "], choose[" + paramIntent + "]");
      }
      if ((paramIntent != null) && (paramlfe != null) && (paramlfe.j == paramInt) && (TextUtils.equals((CharSequence)localObject, paramlfe.d)))
      {
        localObject = b(paramlfe);
        if ((localObject != null) && (((myx)localObject).jdField_a_of_type_Myw != null) && (((myx)localObject).jdField_a_of_type_Myw.d())) {
          a(paramlfe, paramIntent);
        }
      }
      else
      {
        return;
      }
      a(paramlfe, paramIntent, new long[] { mrr.a(paramlfe.d) });
      return;
      paramIntent = null;
      paramInt = i;
    }
  }
  
  public void a(lfe paramlfe, myt parammyt)
  {
    paramlfe = b(paramlfe);
    if (paramlfe == null) {}
    for (paramlfe = null; (paramlfe == null) || (paramlfe.c()) || (!paramlfe.d()); paramlfe = paramlfe.jdField_a_of_type_Myw) {
      return;
    }
    paramlfe.jdField_a_of_type_Myt.a(parammyt);
    a("syncPlayInfo");
  }
  
  public void a(lfe paramlfe, myu parammyu, boolean paramBoolean)
  {
    myv localmyv = null;
    Object localObject = b(paramlfe);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        localmyv = ((myw)localObject).jdField_a_of_type_Myv;
      }
      if ((localmyv != null) && (localmyv.a(parammyu))) {
        if (!paramBoolean) {
          break label148;
        }
      }
    }
    label148:
    for (int i = 2;; i = 3)
    {
      ((myw)localObject).a(4, i, "onStartPlayResult");
      a("updatePlayResult");
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "updatePlayResult, videoInfo[" + parammyu + "], room[" + localObject + "], session[" + paramlfe + "], success[" + paramBoolean + "]");
      }
      return;
      localObject = ((myx)localObject).jdField_a_of_type_Myw;
      break;
    }
  }
  
  public void a(lfe paramlfe, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onSwitchTerminalSuccess, isSelfSwitchTerminal[" + paramBoolean + "], session[" + paramlfe + "]");
    }
  }
  
  void a(myo parammyo)
  {
    this.jdField_a_of_type_Bkys.removeMessages(8);
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    myw localmyw;
    if (localmyx == null)
    {
      localmyw = null;
      if ((localmyw != null) && (localmyw.a() == 5)) {
        break label52;
      }
    }
    label52:
    int i;
    do
    {
      return;
      localmyw = localmyx.jdField_a_of_type_Myw;
      break;
      i = localmyx.jdField_b_of_type_Int;
      localmyw.b("onCloseWTogether");
      d(localmyx);
      c(0, "onCloseWTogether");
      a(localmyx, true);
      if (i == 5) {
        a(200L, "onCloseWTogether");
      }
      mxb.b();
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "onCloseWTogether, result[" + parammyo + "], quitReason[" + i + "]");
  }
  
  void a(myo parammyo, long paramLong, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    Object localObject;
    if (localmyx == null)
    {
      localObject = null;
      if ((localObject != null) && (!((myw)localObject).c()) && (((myw)localObject).d())) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onSyncPlayInfo, room[" + localObject + "]");
      }
    }
    label92:
    do
    {
      return;
      localObject = localmyx.jdField_a_of_type_Myw;
      break;
      if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a((myw)localObject, paramRoomInfo, "onSyncPlayInfo");
      }
    } while (parammyo.jdField_a_of_type_Boolean);
    a(parammyo, localmyx, (myw)localObject, "onSyncPlayInfo");
  }
  
  void a(myo parammyo, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_Bkys.removeMessages(7);
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    if ((localmyx == null) || (paramChooseFileInfo == null) || (!paramChooseFileInfo.equals(localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo))) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onStartWTogether, info[" + localmyx + "]");
      }
    }
    myw localmyw;
    do
    {
      return;
      localmyw = localmyx.jdField_a_of_type_Myw;
      if ((localmyw != null) && (localmyw.e()) && (localmyw.a() == 1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "onStartWTogether, room[" + localmyw + "]");
    return;
    if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      localmyw.a(1, 2, "onStartWTogether");
      a(localmyw, paramRoomInfo, "onStartWTogether");
      if (a(localmyx.jdField_a_of_type_Myr)) {
        this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(6, 200L);
      }
      mrr.a("0X800B62D", paramChooseFileInfo.a(), 0, "", "", paramChooseFileInfo.a(), paramChooseFileInfo.b());
      mxb.a();
      a(localmyx, "onStartWTogether");
    }
    for (;;)
    {
      if (parammyo.jdField_a_of_type_Boolean) {
        c(1, "onStartWTogether");
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onStartWTogether, result[" + parammyo + "]");
      return;
      localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
      localmyx.a(0, "onStartWTogether");
      localmyw.b("onStartWTogether");
      a(localmyx, true);
      if (parammyo.jdField_b_of_type_Int == 1019) {
        a(200L, "onStartWTogether");
      }
    }
  }
  
  void a(myo parammyo, ReqVideoAction paramReqVideoAction, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    if (localmyx == null)
    {
      paramReqVideoAction = null;
      if ((paramReqVideoAction != null) && (paramReqVideoAction.e()) && (!paramReqVideoAction.c()) && (paramReqVideoAction.d())) {
        break label93;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onChangeVideoStatus, room[" + paramReqVideoAction + "]");
      }
    }
    label93:
    do
    {
      return;
      paramReqVideoAction = localmyx.jdField_a_of_type_Myw;
      break;
      if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a(paramReqVideoAction, paramRoomInfo, "onChangeVideoStatus");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onChangeVideoStatus, result[" + parammyo + "]");
      }
    } while (parammyo.jdField_a_of_type_Boolean);
    a(parammyo, localmyx, paramReqVideoAction, "onChangeVideoStatus");
  }
  
  void a(myo parammyo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    myw localmyw;
    if (localmyx == null)
    {
      localmyw = null;
      if (localmyw != null) {
        break label35;
      }
    }
    label35:
    do
    {
      return;
      localmyw = localmyx.jdField_a_of_type_Myw;
      break;
      if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null)) {
        a(localmyw, paramRoomInfo, "onGetRoomInfo");
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onGetRoomInfo, room[" + localmyw + "], result[" + parammyo + "]");
      }
    } while (parammyo.jdField_a_of_type_Boolean);
    a(parammyo, localmyx, localmyw, "onGetRoomInfo");
  }
  
  void a(mys parammys)
  {
    Object localObject = a(parammys.jdField_a_of_type_Int, parammys.jdField_a_of_type_Long);
    if (localObject == null) {}
    for (localObject = null; (localObject == null) || (((myw)localObject).a() != 3) || (((myw)localObject).jdField_a_of_type_Myv == null) || (((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo == null) || (!((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.equals(parammys.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo)); localObject = ((myx)localObject).jdField_a_of_type_Myw)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onRequestUrl, room[" + localObject + "]");
      }
      return;
    }
    if ((parammys.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(parammys.jdField_a_of_type_JavaLangString)))
    {
      if (((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_Myu == null) {
        ((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_Myu = new myu(((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_Int, ((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_a_of_type_JavaLangString, parammys.jdField_a_of_type_JavaLangString, parammys.jdField_b_of_type_JavaLangString, null, null, null, null, 0L);
      }
      ((myw)localObject).a(4, 0, "onRequestUrl");
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder("content:");
      localStringBuilder.append("roomid=").append(parammys.jdField_a_of_type_Long).append("|");
      if ((((myw)localObject).jdField_a_of_type_Myv != null) && (((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo != null))
      {
        localStringBuilder.append("file_id=").append(((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_c_of_type_JavaLangString).append("|");
        localStringBuilder.append("file_uuid=").append(((myw)localObject).jdField_a_of_type_Myv.jdField_a_of_type_ComTencentAvWtogetherDataWTFileInfo.jdField_b_of_type_JavaLangString);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onRequestUrl, result[" + parammys + "] \n" + localStringBuilder.toString());
      return;
      ((myw)localObject).a(3, 3, "onRequestUrl");
    }
  }
  
  public void a(myw parammyw, int paramInt)
  {
    if (parammyw == null) {}
    do
    {
      return;
      ReqVideoAction localReqVideoAction = new ReqVideoAction(parammyw.jdField_a_of_type_Long, paramInt, parammyw.jdField_a_of_type_Myv);
      ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(parammyw.jdField_a_of_type_Int, parammyw.jdField_b_of_type_Long, localReqVideoAction);
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "queryRoomInfo, room[" + parammyw + "], action[" + paramInt + "]");
  }
  
  public void a(myx parammyx)
  {
    b("closeWTogetherMode");
    if (parammyx == null) {}
    for (Object localObject = null; (localObject == null) || (!((myw)localObject).e()) || (!((myw)localObject).d()); localObject = parammyx.jdField_a_of_type_Myw)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "closeWTogetherMode, room[" + localObject + "]");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "closeWTogetherMode, room[" + localObject + "]");
    }
    mxb.a(((myw)localObject).jdField_a_of_type_Myv, "closeWTogetherMode");
    parammyx.a(false, "closeWTogetherMode");
    ((myw)localObject).a(5, 1, "closeWTogetherMode");
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(((myw)localObject).jdField_a_of_type_Int, ((myw)localObject).jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_Bkys.removeMessages(8);
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(8, 30000L);
  }
  
  protected void a(myx parammyx, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onExitWTMode, isAdmin[" + paramBoolean + "]");
    }
    e(parammyx);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(false) });
  }
  
  protected void a(boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "onEnterWTMode, isAdmin[" + paramBoolean + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(9008), Long.valueOf(l), Boolean.valueOf(true) });
    this.jdField_a_of_type_Bkys.post(new WTogetherMng.3(this, l));
  }
  
  public boolean a(int paramInt, String paramString)
  {
    paramString = a(paramInt, paramString, false);
    if (paramString != null) {
      return paramString.a() == 1;
    }
    return false;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(lfe paramlfe)
  {
    boolean bool2 = false;
    paramlfe = b(paramlfe);
    if (paramlfe == null) {}
    for (paramlfe = null;; paramlfe = paramlfe.jdField_a_of_type_Myw)
    {
      boolean bool1 = bool2;
      if (paramlfe != null)
      {
        bool1 = bool2;
        if (paramlfe.a() != 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  public boolean a(lfe paramlfe, ChooseFileInfo paramChooseFileInfo)
  {
    myx localmyx = a(paramlfe);
    if (localmyx != null) {
      localmyx.a(paramlfe, false);
    }
    for (paramlfe = localmyx.a();; paramlfe = null)
    {
      if ((paramlfe == null) || (!paramlfe.e()) || (!paramlfe.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.i("WTogether.Mng", 2, "changeFile, not valid to change file. room[" + paramlfe + "]");
        }
        return false;
      }
      mxb.a(paramlfe.jdField_a_of_type_Myv, "changeFile");
      localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      localmyx.a(true, "changeFile");
      paramlfe.a(paramlfe.jdField_a_of_type_JavaLangString);
      ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(paramlfe.jdField_a_of_type_Int, paramlfe.jdField_b_of_type_Long, paramlfe.jdField_a_of_type_Long, paramChooseFileInfo);
      return true;
    }
  }
  
  public boolean a(lfe paramlfe, ChooseFileInfo paramChooseFileInfo, long[] paramArrayOfLong)
  {
    if ((paramChooseFileInfo == null) || (paramlfe == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "startWatchTogether, illegal param.");
      }
      return false;
    }
    myx localmyx = a(paramlfe);
    if (localmyx != null) {
      localmyx.a(paramlfe, true);
    }
    for (paramlfe = localmyx.a();; paramlfe = null)
    {
      if (paramlfe == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "startWatchTogether, not valid to create room.");
        return false;
      }
      int i = paramlfe.a();
      if (i != 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("WTogether.Mng", 2, "startWatchTogether, illegal state, roomState[" + i + "]");
        return false;
      }
      localmyx.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Bkys.removeMessages(5);
      e(localmyx);
      localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = paramChooseFileInfo;
      localmyx.a(1, "startWatchTogether");
      paramlfe.a(paramlfe.jdField_a_of_type_JavaLangString);
      paramlfe.a(1, 1, "startWatchTogether");
      a(true);
      ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(paramlfe.jdField_a_of_type_Int, paramlfe.jdField_b_of_type_Long, paramChooseFileInfo, paramArrayOfLong, 0);
      this.jdField_a_of_type_Bkys.removeMessages(7);
      this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(7, 30000L);
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "startWatchTogether, room[" + paramlfe + "]");
      }
      return true;
    }
  }
  
  public boolean a(lfe paramlfe, ReqVideoAction paramReqVideoAction)
  {
    myx localmyx = b(paramlfe);
    if (localmyx == null) {}
    for (paramlfe = null; (paramlfe == null) || ((paramlfe.a() != 4) && ((paramlfe.a() != 3) || (paramlfe.b() != 3))) || (paramReqVideoAction == null) || (!paramlfe.e()) || (localmyx.b()); paramlfe = localmyx.jdField_a_of_type_Myw)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "changeVideoStatus, illegal param or no room. info[" + localmyx + "]");
      }
      return false;
    }
    if (paramReqVideoAction.jdField_a_of_type_Int == 4) {
      a(BaseApplicationImpl.getContext().getString(2131695728, new Object[] { String.valueOf(paramReqVideoAction.jdField_a_of_type_Float) }), 0L);
    }
    paramReqVideoAction.jdField_a_of_type_Long = paramlfe.a();
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).a(paramlfe.jdField_a_of_type_Int, paramlfe.jdField_b_of_type_Long, paramReqVideoAction, 0);
    return true;
  }
  
  boolean a(myo parammyo, long paramLong, int paramInt)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool2 = false;
    if ((parammyo == null) || (parammyo.jdField_b_of_type_Int == 1009))
    {
      bool2 = false;
      return bool2;
    }
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    myw localmyw;
    if (localmyx == null)
    {
      localmyw = null;
      switch (paramInt)
      {
      default: 
        label51:
        if ((localmyw == null) || (localmyw.a() != 4) || (paramLong != localmyw.b())) {
          break;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "checkForRetry, {result: " + parammyo + ", seq: " + paramLong + ", action: " + paramInt + "}");
      return bool1;
      localmyw = localmyx.jdField_a_of_type_Myw;
      break label51;
      if ((localmyw == null) || (localmyw.a() != 1))
      {
        bool1 = false;
        continue;
        if (localmyw != null)
        {
          bool1 = bool2;
          if (localmyw.a() != 5) {}
        }
        else
        {
          bool1 = true;
        }
        continue;
        if ((localmyw == null) || (localmyw.a() != 2))
        {
          bool1 = false;
          continue;
          if (localmyw != null)
          {
            bool1 = bool3;
            if (localmyw.a() != 6) {}
          }
          else
          {
            bool1 = true;
          }
          continue;
          if ((localmyw == null) || (!localmyw.d()) || (!localmyx.b()))
          {
            bool1 = false;
            continue;
            bool1 = false;
          }
        }
      }
    }
  }
  
  public myx b(lfe paramlfe)
  {
    if (paramlfe == null) {
      return null;
    }
    return a(paramlfe.f(), paramlfe.b(), false);
  }
  
  public void b(lfe paramlfe)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogether.Mng", 2, "checkAndQuit");
    }
    a(b(paramlfe), 6, "checkAndQuit");
    a(BaseApplicationImpl.getContext().getString(2131695751), 100L);
  }
  
  void b(myo parammyo)
  {
    this.jdField_a_of_type_Bkys.removeMessages(10);
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    myw localmyw;
    if (localmyx == null)
    {
      localmyw = null;
      if (localmyw != null) {
        break label44;
      }
    }
    label44:
    int i;
    do
    {
      return;
      localmyw = localmyx.jdField_a_of_type_Myw;
      break;
      i = localmyx.jdField_b_of_type_Int;
      localmyw.b("onQuitRoom");
      d(localmyx);
      c(0, "onQuitRoom");
      a(localmyx, false);
      if (i == 5) {
        a(200L, "onQuitRoom");
      }
      mxb.b();
    } while (!QLog.isDevelopLevel());
    QLog.i("WTogether.Mng", 4, "onQuitRoom, result[" + parammyo + "], quitReason[" + i + "]");
  }
  
  void b(myo parammyo, ChooseFileInfo paramChooseFileInfo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    if ((localmyx == null) || (paramChooseFileInfo == null) || (!paramChooseFileInfo.equals(localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo))) {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onChangeVideoFile, info[" + localmyx + "]");
      }
    }
    do
    {
      return;
      paramChooseFileInfo = localmyx.jdField_a_of_type_Myw;
      if ((paramChooseFileInfo != null) && (paramChooseFileInfo.e()) && (!paramChooseFileInfo.c()) && (paramChooseFileInfo.d())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WTogether.Mng", 2, "onChangeVideoFile, room[" + paramChooseFileInfo + "]");
    return;
    localmyx.a(false, "onChangeVideoFile");
    if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      a(paramChooseFileInfo, paramRoomInfo, "onChangeVideoFile");
      a(localmyx, "onChangeVideoFile");
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("WTogether.Mng", 4, "onChangeVideoFile, result[" + parammyo + "]");
      }
      if (parammyo.jdField_a_of_type_Boolean) {
        break;
      }
      a(parammyo, localmyx, paramChooseFileInfo, "onChangeVideoFile");
      return;
      localmyx.jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo = null;
    }
  }
  
  void b(myo parammyo, WTogetherCommon.RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_Bkys.removeMessages(9);
    myx localmyx = a(parammyo.jdField_a_of_type_Int, parammyo.jdField_a_of_type_Long);
    if (localmyx == null) {}
    for (Object localObject = null; (localObject == null) || (((myw)localObject).a() != 2); localObject = localmyx.jdField_a_of_type_Myw)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "onEnterRoom, room[" + localObject + "]");
      }
      return;
    }
    if ((parammyo.jdField_a_of_type_Boolean) && (paramRoomInfo != null))
    {
      ((myw)localObject).a(2, 2, "onEnterRoom");
      a((myw)localObject, paramRoomInfo, "onEnterRoom");
      mxb.a();
    }
    for (;;)
    {
      if (parammyo.jdField_a_of_type_Boolean) {
        c(1, "onEnterRoom");
      }
      if (!parammyo.jdField_a_of_type_Boolean) {
        a(localmyx, false);
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.i("WTogether.Mng", 4, "onEnterRoom, result[" + parammyo + "]");
      return;
      ((myw)localObject).b("onEnterRoom");
    }
  }
  
  public void b(myx parammyx)
  {
    if (parammyx == null) {}
    for (Object localObject = null; (localObject == null) || (((myw)localObject).a() != 0) || (((myw)localObject).e()); localObject = parammyx.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "enterRoom, room[" + localObject + "]");
      }
      return;
    }
    if (!nad.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogether.Mng", 2, "enterRoom, not support.");
      }
      this.jdField_a_of_type_Bkys.sendEmptyMessage(11);
      return;
    }
    parammyx.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Bkys.removeMessages(5);
    e(parammyx);
    ((myw)localObject).a(2, 1, "enterRoom");
    a(false);
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).c(((myw)localObject).jdField_a_of_type_Int, ((myw)localObject).jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_Bkys.removeMessages(9);
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(9, 30000L);
  }
  
  public void c(lfe paramlfe)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("WTogether.Mng", 4, "onPeerSwitchTerminal, session[" + paramlfe + "]");
    }
    a(b(paramlfe), 4, "onPeerSwitchTerminal");
  }
  
  public void c(myx parammyx)
  {
    b("quitRoom");
    if ((parammyx == null) || (!parammyx.a())) {}
    do
    {
      return;
      parammyx = parammyx.jdField_a_of_type_Myw;
    } while ((parammyx == null) || (parammyx.e()) || (!parammyx.d()));
    mxb.a(parammyx.jdField_a_of_type_Myv, "quitRoom");
    parammyx.a(6, 1, "quitRoom");
    ((mxc)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(4)).b(parammyx.jdField_a_of_type_Int, parammyx.jdField_b_of_type_Long, 0);
    this.jdField_a_of_type_Bkys.removeMessages(10);
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(10, 30000L);
  }
  
  public void d(lfe paramlfe)
  {
    paramlfe = b(paramlfe);
    if (paramlfe == null) {
      return;
    }
    a(paramlfe, 1, "closeWTogetherMode");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    switch (paramMessage.what)
    {
    default: 
    case 2: 
    case 1: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return true;
                } while (!(paramMessage.obj instanceof String));
                b(paramMessage.arg1, (String)paramMessage.obj);
                return true;
                b();
                return true;
              } while (!(paramMessage.obj instanceof myw));
              a((myw)paramMessage.obj);
              return true;
            } while (!(paramMessage.obj instanceof WTogetherCommon.PushMsg));
            a((WTogetherCommon.PushMsg)paramMessage.obj);
            return true;
            if (QLog.isColorLevel()) {
              QLog.i("WTogether.Mng", 2, "MSG_TRY_ENTER_ROOM");
            }
            paramMessage = lbz.a().a();
          } while ((paramMessage.f()) || (!paramMessage.l()));
          localObject2 = a(paramMessage);
          if (localObject2 != null) {
            ((myx)localObject2).a(paramMessage, true);
          }
          if (localObject2 == null) {}
          for (paramMessage = (Message)localObject1; (paramMessage == null) || (paramMessage.a() != 0); paramMessage = ((myx)localObject2).a())
          {
            QLog.i("WTogether.Mng", 2, "MSG_TRY_ENTER_ROOM, error, room[" + paramMessage + "]");
            return true;
          }
          b((myx)localObject2);
          return true;
          paramMessage = lbz.a().a();
        } while ((paramMessage.f()) || (!paramMessage.l()));
        paramMessage = b(paramMessage);
      } while (paramMessage == null);
      if (a(paramMessage.jdField_a_of_type_Myr)) {
        a(paramMessage.jdField_a_of_type_Myr);
      }
      paramMessage.jdField_a_of_type_Myr = null;
      return true;
    case 7: 
      localObject1 = b(lbz.a().a());
      if (localObject1 == null) {}
      for (paramMessage = null; (paramMessage != null) && (paramMessage.a() == 1) && (paramMessage.b() == 1); paramMessage = ((myx)localObject1).jdField_a_of_type_Myw)
      {
        paramMessage = new myo(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        a(paramMessage, ((myx)localObject1).jdField_a_of_type_ComTencentAvWtogetherDataChooseFileInfo, null);
        return true;
      }
    case 8: 
      paramMessage = b(lbz.a().a());
      if (paramMessage == null) {}
      for (paramMessage = (Message)localObject2; (paramMessage != null) && (paramMessage.a() == 5) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_Myw)
      {
        paramMessage = new myo(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        a(paramMessage);
        return true;
      }
    case 9: 
      paramMessage = b(lbz.a().a());
      if (paramMessage == null) {}
      for (paramMessage = null; (paramMessage != null) && (paramMessage.a() == 2) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_Myw)
      {
        paramMessage = new myo(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        b(paramMessage, null);
        return true;
      }
    case 10: 
      paramMessage = b(lbz.a().a());
      if (paramMessage == null) {}
      for (paramMessage = localObject3; (paramMessage != null) && (paramMessage.a() == 6) && (paramMessage.b() == 1); paramMessage = paramMessage.jdField_a_of_type_Myw)
      {
        paramMessage = new myo(paramMessage.jdField_a_of_type_Int, paramMessage.jdField_b_of_type_Long);
        paramMessage.jdField_a_of_type_Boolean = false;
        paramMessage.jdField_b_of_type_Int = -1000;
        b(paramMessage);
        return true;
      }
    }
    try
    {
      paramMessage = BaseApplicationImpl.getContext();
      localObject1 = paramMessage.getString(2131695754);
      localObject2 = new Intent(paramMessage, SmallScreenDialogActivity.class);
      ((Intent)localObject2).putExtra("tag_model", 1);
      ((Intent)localObject2).putExtra("tag_style", 1);
      ((Intent)localObject2).putExtra("tag_msg", (String)localObject1);
      paramMessage.startActivity((Intent)localObject2);
      return true;
    }
    catch (Throwable paramMessage)
    {
      QLog.i("WTogether.Mng", 2, "MSG_SHOW_NOT_SUPPORT", paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxd
 * JD-Core Version:    0.7.0.1
 */