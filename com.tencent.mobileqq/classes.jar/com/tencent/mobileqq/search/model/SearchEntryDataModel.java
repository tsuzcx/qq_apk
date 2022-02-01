package com.tencent.mobileqq.search.model;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.base.api.SearchEntryConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.HotSearchItem;
import pb.unify.search.UnifySearchDiscovery.Result;
import tencent.im.oidb.search.DynamicDiscovery.HotSearchItem;
import tencent.im.oidb.search.DynamicDiscovery.Result;

public abstract class SearchEntryDataModel
  extends IModel
{
  public int g;
  protected int h;
  protected byte[] i;
  protected final Object j = new Object();
  protected boolean k = false;
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.k = paramBoolean;
  }
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    this.g = paramInt1;
    this.i = paramArrayOfByte;
    this.h = paramInt2;
    this.k = paramBoolean;
  }
  
  public static List<SearchEntryDataModel> a(QQAppInterface paramQQAppInterface, List<DynamicDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_old", 2, "convertPbDataToModel");
    Object localObject1 = Aladdin.getConfig(313);
    int m;
    if (localObject1 != null)
    {
      SearchEntryConfigManager.c = ((AladdinConfig)localObject1).getString("SBWord_Source", "Hot_word");
      m = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_UIType", 0);
      SearchEntryConfigManager.d = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_RwordNum", 8);
    }
    else
    {
      m = 0;
    }
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      Object localObject2 = null;
      localObject1 = null;
      Object localObject3 = null;
      int n = 0;
      while (n < paramList.size())
      {
        Object localObject4 = (DynamicDiscovery.Result)paramList.get(n);
        int i2 = ((DynamicDiscovery.Result)localObject4).type.get();
        if (i2 != 1)
        {
          if (i2 != 3)
          {
            if (i2 != 7)
            {
              localObject5 = null;
              localObject4 = localObject1;
              break label423;
            }
            if (((DynamicDiscovery.Result)localObject4).hot_search_items.get().size() < 6) {
              localObject2 = null;
            } else {
              localObject2 = new HotWordSearchEntryDataModel(paramQQAppInterface, i2, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
            }
            if (m == 1) {
              localObject2 = null;
            }
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject5;
          }
          else
          {
            localObject5 = new BusinessSearchEntryDataModel(paramQQAppInterface, i2, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
            localObject3 = localObject5;
            localObject4 = localObject1;
            break label423;
          }
        }
        else
        {
          localObject1 = ((DynamicDiscovery.Result)localObject4).hot_search_items.get();
          if (((List)localObject1).size() < 6)
          {
            localObject1 = null;
          }
          else
          {
            if (SearchEntryConfigManager.c.contentEquals("Hot_word"))
            {
              localObject5 = new String[((List)localObject1).size()];
              int i1 = 0;
              while (i1 < ((List)localObject1).size())
              {
                localObject5[i1] = ((DynamicDiscovery.HotSearchItem)((List)localObject1).get(i1)).title.get().toStringUtf8();
                i1 += 1;
              }
              SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), (String[])localObject5);
            }
            localObject1 = new HotWordSearchEntryDataModel(paramQQAppInterface, i2, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
          }
          if (m == 2) {
            localObject1 = null;
          }
          localObject4 = localObject1;
          localObject5 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject5;
        }
        Object localObject5 = localObject2;
        localObject2 = localObject1;
        label423:
        if (localObject5 != null) {
          ((SearchEntryDataModel)localObject5).d();
        }
        n += 1;
        localObject1 = localObject4;
      }
      if (m != 3)
      {
        if (m == 4) {
          break label508;
        }
        if (m != 6)
        {
          if (localObject3 != null) {
            localArrayList.add(localObject3);
          }
          arrayOfInt[0] = 3;
          if (localObject1 != null) {
            localArrayList.add(localObject1);
          }
          arrayOfInt[1] = 1;
        }
      }
      for (;;)
      {
        break;
        break label552;
        label508:
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        arrayOfInt[0] = 7;
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        arrayOfInt[1] = 1;
        continue;
        label552:
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        arrayOfInt[0] = 1;
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        arrayOfInt[1] = 7;
      }
      boolean bool = a(arrayOfInt, SearchEntryConfigManager.a(paramQQAppInterface, paramInt, false));
      SearchEntryConfigManager.a(paramQQAppInterface, paramInt, bool, false);
      if (bool) {
        SearchEntryConfigManager.a(paramQQAppInterface, paramInt, arrayOfInt, false);
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("convertPbDataToModel, modelList = ");
      paramQQAppInterface.append(localArrayList.size());
      QLog.d("SearchEntryDataModel", 2, paramQQAppInterface.toString());
    }
    return localArrayList;
  }
  
  private static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1 != null)
    {
      if (paramArrayOfInt2 == null) {
        return true;
      }
      if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
        return true;
      }
      int m = 0;
      while (m < paramArrayOfInt1.length)
      {
        if (paramArrayOfInt1[m] != paramArrayOfInt2[m]) {
          return true;
        }
        m += 1;
      }
      return false;
    }
    return true;
  }
  
  public static List<SearchEntryDataModel> b(QQAppInterface paramQQAppInterface, List<UnifySearchDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "convertUnifyPbDataToModel");
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      int m = 0;
      while (m < paramList.size())
      {
        Object localObject = (UnifySearchDiscovery.Result)paramList.get(m);
        arrayOfInt[m] = ((UnifySearchDiscovery.Result)paramList.get(m)).type.get();
        int i1 = ((UnifySearchDiscovery.Result)localObject).type.get();
        if (i1 != 1) {
          if (i1 != 3) {
            if (i1 == 8) {}
          }
        }
        List localList;
        do
        {
          localObject = null;
          break;
          localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
          arrayOfString = new String[localList.size()];
          n = 0;
          while (n < localList.size())
          {
            arrayOfString[n] = ((UnifySearchDiscovery.HotSearchItem)localList.get(n)).title.get().toStringUtf8();
            n += 1;
          }
          SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
          localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, i1, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          break;
          localObject = new BusinessSearchEntryDataModel(paramQQAppInterface, i1, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          break;
          localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
        } while (localList.size() < 6);
        String[] arrayOfString = new String[localList.size()];
        int n = 0;
        while (n < localList.size())
        {
          arrayOfString[n] = ((UnifySearchDiscovery.HotSearchItem)localList.get(n)).title.get().toStringUtf8();
          n += 1;
        }
        SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
        localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, i1, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
        if (localObject != null)
        {
          ((SearchEntryDataModel)localObject).d();
          localArrayList.add(localObject);
        }
        m += 1;
      }
      boolean bool = a(arrayOfInt, SearchEntryConfigManager.a(paramQQAppInterface, paramInt, true));
      SearchEntryConfigManager.a(paramQQAppInterface, paramInt, bool, true);
      if (bool) {
        SearchEntryConfigManager.a(paramQQAppInterface, paramInt, arrayOfInt, true);
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("convertPbDataToModel, modelList = ");
      paramQQAppInterface.append(localArrayList.size());
      QLog.d("SearchEntryDataModel", 2, paramQQAppInterface.toString());
    }
    return localArrayList;
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public void c()
  {
    synchronized (this.j)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplication localBaseApplication;
      StringBuilder localStringBuilder;
      if (!this.k)
      {
        localBaseApplication = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefixpref_search_model_data");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(this.g);
        localStringBuilder.append("_");
        localStringBuilder.append(this.h);
        this.i = FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()));
        a(this.i);
      }
      else
      {
        localBaseApplication = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefix_unifypref_search_model_data");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(this.g);
        localStringBuilder.append("_");
        localStringBuilder.append(this.h);
        this.i = FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()));
        a(this.i);
      }
      return;
    }
  }
  
  protected void d()
  {
    if (this.i == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, mRawData is null");
      }
      return;
    }
    ThreadManager.post(new SearchEntryDataModel.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */