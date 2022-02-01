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
  public static String a = "TroopFileExpandableListAdapter<QFile>";
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
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!paramQQAppInterface.a(this)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.registerObserver(this);
    }
  }
  
  private List<TroopFileInfo> a(List<TroopFileInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
    return paramList;
  }
  
  public List<TroopFileInfo> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
    int i = 0;
    int j;
    if (localObject != null)
    {
      i = ((ITroopFileViewBinder)localObject).d();
      j = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.e();
    }
    else
    {
      j = 0;
    }
    while (i <= j - 1)
    {
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      localObject = (TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject != null)
      {
        localObject = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(((TroopFileInfo)localObject).a);
        if (localObject != null)
        {
          ((TroopFileItem)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((TroopFileItem)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext);
    int i = 0;
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long))) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
    localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_JavaUtilList;
    }
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      if (!bool)
      {
        b(0);
        a((List)localObject1, true, paramInt2, true);
      }
    }
    else
    {
      if (bool)
      {
        if (paramInt1 != 0) {
          paramInt1 = i;
        } else {
          paramInt1 = 2;
        }
        b(paramInt1);
        return;
      }
      b(1);
      TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo.e != 2)
    {
      if (paramTroopFileInfo.e == 3) {
        return;
      }
      int j = this.jdField_a_of_type_JavaUtilList.size();
      TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
      int i = 0;
      Object localObject;
      while (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) != null) && (((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.jdField_b_of_type_JavaLangString)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
          localStringBuilder.append(this.jdField_a_of_type_Long);
          localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
          if (localObject != null)
          {
            if ((((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList == null) || (((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap == null)) {
              break;
            }
            ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap.remove(((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
            if (i < ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.size())
            {
              paramTroopFileInfo = (TroopFileInfo)((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.remove(i);
              if ((paramTroopFileInfo != null) && (paramTroopFileInfo.e != 12) && (localTroopFileInfo != null)) {
                localTroopFileInfo.h -= 1;
              }
              if ((paramTroopFileInfo != null) && (paramTroopFileInfo.e != 12)) {
                ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
              }
              this.d = false;
              a(((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_Boolean, 0, false);
              break;
            }
            paramTroopFileInfo = jdField_a_of_type_JavaLangString;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("<TroopFile> onDelete remove has err.index>size");
            ((StringBuilder)localObject).append(i);
            QLog.e(paramTroopFileInfo, 1, ((StringBuilder)localObject).toString());
            break;
          }
        }
        i += 1;
      }
      if ((localTroopFileInfo != null) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L) && (localTroopFileInfo.d))
      {
        localTroopFileInfo.b((int)NetConnInfoCenter.getServerTime());
        paramTroopFileInfo = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(localTroopFileInfo.g);
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        paramTroopFileInfo = (TroopFileManager.FileManagerStatus)paramTroopFileInfo.get(((StringBuilder)localObject).toString());
        if (paramTroopFileInfo != null)
        {
          if (paramTroopFileInfo.jdField_a_of_type_JavaUtilList != null)
          {
            paramTroopFileInfo.jdField_a_of_type_JavaUtilList.remove(localTroopFileInfo);
            paramTroopFileInfo.jdField_a_of_type_JavaUtilList.add(0, localTroopFileInfo);
          }
          paramTroopFileInfo.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(paramTroopFileInfo.jdField_a_of_type_JavaUtilList, paramTroopFileInfo.jdField_a_of_type_Boolean, 0, false);
        }
      }
    }
  }
  
  public void a(TroopFileInfo paramTroopFileInfo, String paramString)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    if (this.jdField_b_of_type_JavaLangString.equals("/"))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      localObject1 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        if (((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList == null) {
          return;
        }
        localObject2 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramString);
        if ((localObject2 != null) && (((TroopFileInfo)localObject2).d))
        {
          ((TroopFileInfo)localObject2).h += 1;
          ((TroopFileInfo)localObject2).b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          while (i < j)
          {
            if (localObject2 == this.jdField_a_of_type_JavaUtilList.get(i))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList.remove(i);
              break;
            }
            i += 1;
          }
          ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList.add(0, localObject2);
          ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Boolean, 0, false);
        }
      }
      else
      {
        return;
      }
    }
    if (this.jdField_b_of_type_JavaLangString.equals(paramString))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      paramString = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
      if (paramString != null)
      {
        if (paramString.jdField_a_of_type_JavaUtilList == null) {
          return;
        }
        boolean bool = paramString.jdField_a_of_type_Boolean;
        j = this.jdField_a_of_type_JavaUtilList.size();
        i = 0;
        while (i < j)
        {
          if ((!((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramTroopFileInfo.a() >= ((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
          {
            paramString.jdField_a_of_type_JavaUtilList.add(i, paramTroopFileInfo);
            paramString.jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
            a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
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
        paramString.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      }
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
    if (paramList == null) {
      return;
    }
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
    if ((paramBoolean1) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
      if (paramList != null) {
        paramList.d(7);
      }
    }
  }
  
  public void a(List<TroopFileInfo> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if (this.jdField_b_of_type_JavaLangString.equals(paramString))
    {
      if (this.jdField_a_of_type_Long != paramLong) {
        return;
      }
      if (paramList == null)
      {
        paramList = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
        if (paramList != null) {
          paramList.d(3);
        }
        FMToastUtil.a(2131697554);
        if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
          b(1);
        }
        return;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
      if (paramString != null) {
        paramString.d(4);
      }
      a(paramList, paramBoolean, 0, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (!paramBoolean)
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      if (localList != null) {
        localList.clear();
      }
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
    if (paramBoolean)
    {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramTroopFileInfo)) {
        this.jdField_b_of_type_JavaUtilList.add(paramTroopFileInfo);
      }
    }
    else {
      this.jdField_b_of_type_JavaUtilList.remove(paramTroopFileInfo);
    }
    TroopFileItem.OnItemSelectedListener localOnItemSelectedListener = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataTroopFileItem$OnItemSelectedListener;
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.a(paramBoolean, paramTroopFileInfo);
    }
    notifyDataSetChanged();
  }
  
  public boolean a(TroopFileInfo paramTroopFileInfo)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    if ((localList != null) && (!localList.isEmpty())) {
      return this.jdField_b_of_type_JavaUtilList.contains(paramTroopFileInfo);
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
    if (localObject != null) {
      ((TroopFileManager)localObject).unregisterObserver(this);
    }
    localObject = this.jdField_b_of_type_JavaUtilList;
    if (localObject != null) {
      ((List)localObject).clear();
    }
  }
  
  protected void b(int paramInt)
  {
    ITroopFileViewBinder localITroopFileViewBinder = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
    if (localITroopFileViewBinder != null) {
      localITroopFileViewBinder.c(paramInt);
    }
  }
  
  public void b(TroopFileInfo paramTroopFileInfo)
  {
    if (paramTroopFileInfo == null) {
      return;
    }
    int i = paramTroopFileInfo.e;
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      if (i != 12)
      {
        if ((this.jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.g)) || (this.jdField_a_of_type_Long != 0L))
        {
          TroopFileItem localTroopFileItem = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(paramTroopFileInfo.a);
          if (localTroopFileItem != null)
          {
            if (!localTroopFileItem.a.a.equals(paramTroopFileInfo.a)) {
              return;
            }
            localTroopFileItem.a = paramTroopFileInfo;
            localTroopFileItem.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          }
        }
        else
        {
          paramTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
          if (paramTroopFileInfo != null)
          {
            paramTroopFileInfo = (TroopFileItem)this.jdField_a_of_type_JavaUtilMap.get(paramTroopFileInfo.a);
            if (paramTroopFileInfo == null) {
              return;
            }
            paramTroopFileInfo.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          }
        }
        return;
      }
      if (this.jdField_a_of_type_JavaUtilMap.remove(paramTroopFileInfo.a) != null)
      {
        this.d = false;
        notifyDataSetChanged();
      }
    }
  }
  
  public void c(TroopFileInfo paramTroopFileInfo) {}
  
  public void d(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.jdField_c_of_type_Boolean) && (paramTroopFileInfo.e == 6))
    {
      Object localObject1 = (TroopFileInfo)this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.get(paramTroopFileInfo.g);
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((localObject1 != null) && (this.jdField_b_of_type_JavaLangString.equals(((TroopFileInfo)localObject1).g)) && (((TroopFileInfo)localObject1).d))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TroopFileInfo)localObject1).g);
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_Long);
        localObject2 = (TroopFileManager.FileManagerStatus)((Map)localObject2).get(((StringBuilder)localObject3).toString());
        if (localObject2 != null)
        {
          if (((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_JavaUtilList == null) {
            return;
          }
          if (TextUtils.isEmpty(paramTroopFileInfo.c())) {
            if (paramTroopFileInfo.jdField_b_of_type_Long == 0L)
            {
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject4 = ((QQAppInterface)localObject3).getCurrentAccountUin();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(this.jdField_b_of_type_Long);
              localStringBuilder.append("");
              paramTroopFileInfo.f = ContactUtils.a((QQAppInterface)localObject3, (String)localObject4, localStringBuilder.toString(), 1, 0);
            }
            else
            {
              paramTroopFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
            }
          }
          ((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_JavaUtilList.remove(localObject1);
          ((TroopFileInfo)localObject1).b(paramTroopFileInfo.a());
          ((TroopFileInfo)localObject1).h += 1;
          ((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_JavaUtilList.add(0, localObject1);
          a(((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_Boolean, 0, false);
          ((TroopFileManager.FileManagerStatus)localObject2).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        }
        else
        {
          return;
        }
      }
      if (this.jdField_b_of_type_JavaLangString.equals(paramTroopFileInfo.g))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramTroopFileInfo.g);
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
        localObject1 = (TroopFileManager.FileManagerStatus)((Map)localObject1).get(((StringBuilder)localObject2).toString());
        if (localObject1 != null)
        {
          if (((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList == null) {
            return;
          }
          boolean bool = ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Boolean;
          int j = this.jdField_a_of_type_JavaUtilList.size();
          if (TextUtils.isEmpty(paramTroopFileInfo.c())) {
            if (paramTroopFileInfo.jdField_b_of_type_Long == 0L)
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject3 = ((QQAppInterface)localObject2).getCurrentAccountUin();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(this.jdField_b_of_type_Long);
              ((StringBuilder)localObject4).append("");
              paramTroopFileInfo.f = ContactUtils.a((QQAppInterface)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString(), 1, 0);
            }
            else
            {
              paramTroopFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
            }
          }
          if (this.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopFileInfo);
            ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
          }
          int i = 0;
          while (i < j)
          {
            if ((!((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramTroopFileInfo.a() >= ((TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList.add(i, paramTroopFileInfo);
              ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
              notifyDataSetChanged();
              break;
            }
            if ((i == j - 1) && (bool))
            {
              ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList.add(paramTroopFileInfo);
              ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
            }
            i += 1;
          }
          ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject1).jdField_a_of_type_Boolean, 0, false);
        }
        return;
      }
      this.d = false;
    }
  }
  
  public void e(TroopFileInfo paramTroopFileInfo)
  {
    if ((paramTroopFileInfo.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      paramTroopFileInfo.a = UUID.randomUUID();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b.put(paramTroopFileInfo.a, paramTroopFileInfo);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localObject = (TroopFileManager.FileManagerStatus)((Map)localObject).get(localStringBuilder.toString());
      if (localObject != null)
      {
        if ((((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList != null) && (((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap != null))
        {
          ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList.add(0, paramTroopFileInfo);
          ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilMap.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.c.put(paramTroopFileInfo.jdField_b_of_type_JavaLangString, paramTroopFileInfo);
        a(((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_JavaUtilList, ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_Boolean, 0, false);
        ((TroopFileManager.FileManagerStatus)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    int i = this.jdField_a_of_type_JavaUtilList.size();
    boolean bool = true;
    if (paramInt >= i)
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getView: error. position[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("] fileListSize[");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList.size());
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    TroopFileInfo localTroopFileInfo = (TroopFileInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramView == null)
    {
      localObject2 = new TroopFileItem(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560831, this.jdField_c_of_type_Int);
      ((TroopFileItem)localObject2).a(this);
      paramView = ((TroopFileItem)localObject2).b;
      if (paramView == null)
      {
        localObject2 = paramView;
        break label314;
      }
      paramView.setTag(localObject2);
      localObject1 = localObject2;
    }
    else
    {
      Object localObject3 = paramView.getTag();
      localObject1 = localObject2;
      if ((localObject3 instanceof TroopFileItem)) {
        localObject1 = (TroopFileItem)localObject3;
      }
    }
    this.jdField_a_of_type_JavaUtilMap.put(localTroopFileInfo.a, localObject1);
    if (localObject1 != null)
    {
      ((TroopFileItem)localObject1).a = localTroopFileInfo;
      ((TroopFileItem)localObject1).a(this.e);
      ((TroopFileItem)localObject1).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((!this.e) || (!a(localTroopFileInfo))) {
        bool = false;
      }
      ((TroopFileItem)localObject1).b(bool);
      ((TroopFileItem)localObject1).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
    }
    localObject2 = paramView;
    localObject1 = paramView;
    label314:
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject2, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      a();
    }
    return true;
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
      if (this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2)
      {
        paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager;
        if (paramAbsListView != null) {
          if (paramAbsListView.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long))
          {
            paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder;
            if (paramAbsListView != null) {
              paramAbsListView.d(8);
            }
          }
          else
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDataITroopFileViewBinder.d(7);
            if (TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) != 0) {
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileManager.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopFileShowAdapter
 * JD-Core Version:    0.7.0.1
 */