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
  implements IModel
{
  protected final Object a;
  protected boolean a;
  protected byte[] a;
  public int c;
  protected int d;
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public SearchEntryDataModel(QQAppInterface paramQQAppInterface, int paramInt1, byte[] paramArrayOfByte, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.c = paramInt1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.d = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static List<SearchEntryDataModel> a(QQAppInterface paramQQAppInterface, List<DynamicDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_old", 2, "convertPbDataToModel");
    Object localObject1 = Aladdin.getConfig(313);
    int i;
    if (localObject1 != null)
    {
      SearchEntryConfigManager.b = ((AladdinConfig)localObject1).getString("SBWord_Source", "Hot_word");
      i = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_UIType", 0);
      SearchEntryConfigManager.a = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_RwordNum", 8);
    }
    else
    {
      i = 0;
    }
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      Object localObject2 = null;
      localObject1 = null;
      Object localObject3 = null;
      int j = 0;
      while (j < paramList.size())
      {
        Object localObject4 = (DynamicDiscovery.Result)paramList.get(j);
        int m = ((DynamicDiscovery.Result)localObject4).type.get();
        if (m != 1)
        {
          if (m != 3)
          {
            if (m != 7)
            {
              localObject5 = null;
              localObject4 = localObject1;
              break label423;
            }
            if (((DynamicDiscovery.Result)localObject4).hot_search_items.get().size() < 6) {
              localObject2 = null;
            } else {
              localObject2 = new HotWordSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
            }
            if (i == 1) {
              localObject2 = null;
            }
            localObject5 = localObject2;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject5;
          }
          else
          {
            localObject5 = new BusinessSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
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
            if (SearchEntryConfigManager.b.contentEquals("Hot_word"))
            {
              localObject5 = new String[((List)localObject1).size()];
              int k = 0;
              while (k < ((List)localObject1).size())
              {
                localObject5[k] = ((DynamicDiscovery.HotSearchItem)((List)localObject1).get(k)).title.get().toStringUtf8();
                k += 1;
              }
              SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), (String[])localObject5);
            }
            localObject1 = new HotWordSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
          }
          if (i == 2) {
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
          ((SearchEntryDataModel)localObject5).b();
        }
        j += 1;
        localObject1 = localObject4;
      }
      if (i != 3)
      {
        if (i == 4) {
          break label508;
        }
        if (i != 6)
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
      int i = 0;
      while (i < paramArrayOfInt1.length)
      {
        if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
          return true;
        }
        i += 1;
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
      int i = 0;
      while (i < paramList.size())
      {
        Object localObject = (UnifySearchDiscovery.Result)paramList.get(i);
        arrayOfInt[i] = ((UnifySearchDiscovery.Result)paramList.get(i)).type.get();
        int k = ((UnifySearchDiscovery.Result)localObject).type.get();
        if (k != 1) {
          if (k != 3) {
            if (k == 8) {}
          }
        }
        List localList;
        do
        {
          localObject = null;
          break;
          localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
          arrayOfString = new String[localList.size()];
          j = 0;
          while (j < localList.size())
          {
            arrayOfString[j] = ((UnifySearchDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
            j += 1;
          }
          SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
          localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          break;
          localObject = new BusinessSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          break;
          localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
        } while (localList.size() < 6);
        String[] arrayOfString = new String[localList.size()];
        int j = 0;
        while (j < localList.size())
        {
          arrayOfString[j] = ((UnifySearchDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
          j += 1;
        }
        SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
        localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
        if (localObject != null)
        {
          ((SearchEntryDataModel)localObject).b();
          localArrayList.add(localObject);
        }
        i += 1;
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
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      BaseApplication localBaseApplication;
      StringBuilder localStringBuilder;
      if (!this.jdField_a_of_type_Boolean)
      {
        localBaseApplication = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefixpref_search_model_data");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(this.c);
        localStringBuilder.append("_");
        localStringBuilder.append(this.d);
        this.jdField_a_of_type_ArrayOfByte = FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()));
        a(this.jdField_a_of_type_ArrayOfByte);
      }
      else
      {
        localBaseApplication = BaseApplication.getContext();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("search_discovery_sp_prefix_unifypref_search_model_data");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localStringBuilder.append("_");
        localStringBuilder.append(this.c);
        localStringBuilder.append("_");
        localStringBuilder.append(this.d);
        this.jdField_a_of_type_ArrayOfByte = FileUtils.fileToBytes(localBaseApplication.getFileStreamPath(localStringBuilder.toString()));
        a(this.jdField_a_of_type_ArrayOfByte);
      }
      return;
    }
  }
  
  public abstract void a(byte[] paramArrayOfByte);
  
  protected void b()
  {
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SearchEntryDataModel", 2, "saveDataToLocal, mRawData is null");
      }
      return;
    }
    ThreadManager.post(new SearchEntryDataModel.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */