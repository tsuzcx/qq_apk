package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileObserver;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileManager.FileManagerStatus;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TroopFileShowAdapter
  extends BaseAdapter
  implements Handler.Callback, TroopFileObserver, TroopFileItem.OnItemSelectedListener, AbsListView.OnScrollListener
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ITroopFileViewBinder jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
  private TroopFileItem.OnItemSelectedListener jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener = null;
  private TroopFileManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<TroopFileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, TroopFileItem> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<TroopFileInfo> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  private boolean e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public TroopFileShowAdapter(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.registerObserver(this);
    }
  }
  
  private List<TroopFileInfo> a(List<TroopFileInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)paramList.next();
      if ((TextUtils.isEmpty(localTroopFileInfo.jdField_b_of_type_JavaLangString)) || (!localTroopFileInfo.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localTroopFileInfo);
      }
    }
    return localArrayList;
  }
  
  public List<TroopFileInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder != null)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d();
      j = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject).a);
        if (localObject != null)
        {
          ((TroopFileItem)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((TroopFileItem)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      j = 0;
      i = 0;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool = NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
    {
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (!bool)
        {
          b(0);
          a((List)localObject, true, paramInt2, true);
        }
        return;
        paramInt1 = 0;
        break;
      }
      if (bool)
      {
        if (paramInt1 != 0) {}
        for (paramInt1 = i;; paramInt1 = 2)
        {
          b(paramInt1);
          return;
        }
      }
      b(1);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.e == 2) || (paramTroopFileInfo.e == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localFileManagerStatus == null) {
          break label451;
        }
        if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) && (localFileManagerStatus.jdField_a_of_type_JavaUtilMap != null))
        {
          localFileManagerStatus.jdField_a_of_type_JavaUtilMap.remove(((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localFileManagerStatus.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          paramTroopFileInfo = (TroopFileInfo)localFileManagerStatus.jdField_a_of_type_JavaUtilList.remove(i);
          if ((paramTroopFileInfo != null) && (paramTroopFileInfo.e != 12) && (localTroopFileInfo != null)) {
            localTroopFileInfo.h -= 1;
          }
          if ((paramTroopFileInfo != null) && (paramTroopFileInfo.e != 12)) {
            localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.d = false;
          a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localTroopFileInfo == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localTroopFileInfo.d)) {
          break label449;
        }
        localTroopFileInfo.b((int)NetConnInfoCenter.getServerTime());
        paramTroopFileInfo = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(localTroopFileInfo.g + this.jdField_a_of_type_Long);
        if (paramTroopFileInfo == null) {
          break;
        }
        if (paramTroopFileInfo.jdField_a_of_type_JavaUtilList != null)
        {
          paramTroopFileInfo.jdField_a_of_type_JavaUtilList.remove(localTroopFileInfo);
          paramTroopFileInfo.jdField_a_of_type_JavaUtilList.add(0, localTroopFileInfo);
        }
        paramTroopFileInfo.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(paramTroopFileInfo.jdField_a_of_type_JavaUtilList, paramTroopFileInfo.jdField_a_of_type_Boolean, 0, false);
        return;
        label421:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "<TroopFile> onDelete remove has err.index>size" + i);
      }
      label449:
      break;
      label451:
      i += 1;
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString)
  {
    if (paramTroopFileInfo == null) {}
    do
    {
      do
      {
        TroopFileManager.FileManagerStatus localFileManagerStatus;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localFileManagerStatus == null) || (localFileManagerStatus.jdField_a_of_type_JavaUtilList == null));
        TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramString);
        if ((localTroopFileInfo != null) && (localTroopFileInfo.d))
        {
          localTroopFileInfo.h += 1;
          localTroopFileInfo.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localTroopFileInfo != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localFileManagerStatus.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(0, localTroopFileInfo);
          localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramTroopFileInfo.a() >= ((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, paramTroopFileInfo);
          paramString.jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
          a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
        }
      }
      else
      {
        paramString.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        return;
        i += 1;
        break;
      }
      if ((i == j - 1) && (bool))
      {
        paramString.jdField_a_of_type_JavaUtilList.add(paramTroopFileInfo);
        paramString.jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(ITroopFileViewBinder paramITroopFileViewBinder)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder = paramITroopFileViewBinder;
  }
  
  public void a(TroopFileItem.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(a(paramList));
      if (paramList.size() == 0)
      {
        if ("/".equals(this.jdField_b_of_type_JavaLangString))
        {
          b(3);
          return;
        }
        b(6);
        return;
      }
      this.d = false;
      notifyDataSetChanged();
      b(4);
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder == null));
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(7);
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(3);
      }
      FMToastUtil.a(2131697548);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(4);
    }
    a(paramList, paramBoolean, 0, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilList != null)) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, TroopFileInfo paramTroopFileInfo)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (paramTroopFileInfo == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramTroopFileInfo)) {
        this.jdField_b_of_type_JavaUtilList.add(paramTroopFileInfo);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener.a(paramBoolean, paramTroopFileInfo);
      }
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramTroopFileInfo);
    }
  }
  
  public boolean a(TroopFileInfo paramTroopFileInfo)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramTroopFileInfo);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.c(paramInt);
    }
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          TroopFileItem localTroopFileItem;
          do
          {
            return;
            switch (paramTroopFileInfo.e)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.g)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localTroopFileItem = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(paramTroopFileInfo.a);
            }
          } while ((localTroopFileItem == null) || (!localTroopFileItem.a.a.equals(paramTroopFileInfo.a)));
          localTroopFileItem.a = paramTroopFileInfo;
          localTroopFileItem.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          paramTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
        } while (paramTroopFileInfo == null);
        paramTroopFileInfo = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(paramTroopFileInfo.a);
      } while (paramTroopFileInfo == null);
      paramTroopFileInfo.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(paramTroopFileInfo.a) == null);
    this.d = false;
    notifyDataSetChanged();
  }
  
  public void c(TroopFileInfo paramTroopFileInfo) {}
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    Object localObject;
    TroopFileManager.FileManagerStatus localFileManagerStatus;
    if ((paramTroopFileInfo.jdField_c_of_type_Boolean) && (paramTroopFileInfo.e == 6))
    {
      localObject = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((TroopFileInfo)localObject).g)) || (!((TroopFileInfo)localObject).d)) {
        break label251;
      }
      localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(((TroopFileInfo)localObject).g + this.jdField_a_of_type_Long);
      if ((localFileManagerStatus != null) && (localFileManagerStatus.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(paramTroopFileInfo.c()))
      {
        if (paramTroopFileInfo.jdField_b_of_type_Long != 0L) {
          break;
        }
        paramTroopFileInfo.f = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localFileManagerStatus.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((TroopFileInfo)localObject).b(paramTroopFileInfo.a());
      ((TroopFileInfo)localObject).h += 1;
      localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, 0, false);
      localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.g)) {
        break label618;
      }
      localObject = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(paramTroopFileInfo.g + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(paramTroopFileInfo.c()))
    {
      if (paramTroopFileInfo.jdField_b_of_type_Long == 0L) {
        paramTroopFileInfo.f = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.add(paramTroopFileInfo);
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramTroopFileInfo.a() >= ((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.add(i, paramTroopFileInfo);
          ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        paramTroopFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        paramTroopFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.add(paramTroopFileInfo);
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
      }
      i += 1;
    }
    label618:
    this.d = false;
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      paramTroopFileInfo.a = UUID.randomUUID();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b.put(paramTroopFileInfo.a, paramTroopFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
      TroopFileManager.FileManagerStatus localFileManagerStatus = (TroopFileManager.FileManagerStatus)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localFileManagerStatus != null)
      {
        if ((localFileManagerStatus.jdField_a_of_type_JavaUtilList != null) && (localFileManagerStatus.jdField_a_of_type_JavaUtilMap != null))
        {
          localFileManagerStatus.jdField_a_of_type_JavaUtilList.add(0, paramTroopFileInfo);
          localFileManagerStatus.jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
        a(localFileManagerStatus.jdField_a_of_type_JavaUtilList, localFileManagerStatus.jdField_a_of_type_Boolean, 0, false);
        localFileManagerStatus.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getView: error. position[" + paramInt + "] fileListSize[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
    }
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      TroopFileItem localTroopFileItem = new TroopFileItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560956, this.jdField_c_of_type_Int);
      localTroopFileItem.a(this);
      paramView = localTroopFileItem.b;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localTroopFileItem);
      localObject = localTroopFileItem;
    }
    for (;;)
    {
      label157:
      this.jdField_a_of_type_JavaUtilMap.put(localTroopFileInfo.a, localObject);
      if (localObject != null)
      {
        ((TroopFileItem)localObject).a = localTroopFileInfo;
        ((TroopFileItem)localObject).a(this.e);
        ((TroopFileItem)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.e) || (!a(localTroopFileInfo))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((TroopFileItem)localObject).b(bool);
        ((TroopFileItem)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof TroopFileItem)) {
          break label291;
        }
        localObject = (TroopFileItem)localObject;
        break label157;
      }
      label291:
      localObject = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        a();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = true;
      QLog.e(jdField_a_of_type_JavaLangString, 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager != null))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(7);
      } while (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter
 * JD-Core Version:    0.7.0.1
 */