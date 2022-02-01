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
import com.tencent.mobileqq.search.SearchEntryConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import pb.unify.search.UnifySearchDiscovery.HotSearchItem;
import pb.unify.search.UnifySearchDiscovery.Result;
import pb.unite.search.DynamicDiscovery.HotSearchItem;
import pb.unite.search.DynamicDiscovery.Result;

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
    int i = 0;
    Object localObject1 = Aladdin.getConfig(313);
    if (localObject1 != null)
    {
      SearchEntryConfigManager.b = ((AladdinConfig)localObject1).getString("SBWord_Source", "Hot_word");
      i = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_UIType", 0);
      SearchEntryConfigManager.a = ((AladdinConfig)localObject1).getIntegerFromString("SearchPage_RwordNum", 8);
    }
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    Object localObject3;
    Object localObject2;
    if (paramList.size() > 0)
    {
      int j = 0;
      localObject1 = null;
      localObject3 = null;
      localObject2 = null;
      if (j < paramList.size())
      {
        Object localObject4 = (DynamicDiscovery.Result)paramList.get(j);
        Object localObject5 = null;
        int m = ((DynamicDiscovery.Result)localObject4).type.get();
        switch (m)
        {
        default: 
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          localObject4 = localObject5;
        case 1: 
        case 3: 
          for (;;)
          {
            if (localObject4 != null) {
              ((SearchEntryDataModel)localObject4).b();
            }
            j += 1;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject4;
            break;
            localObject2 = ((DynamicDiscovery.Result)localObject4).hot_search_items.get();
            if (((List)localObject2).size() < 6) {}
            for (localObject4 = null;; localObject4 = new HotWordSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false))
            {
              if (i == 2) {
                localObject4 = null;
              }
              localObject2 = localObject3;
              localObject3 = localObject4;
              break;
              if (SearchEntryConfigManager.b.contentEquals("Hot_word"))
              {
                localObject5 = new String[((List)localObject2).size()];
                int k = 0;
                while (k < ((List)localObject2).size())
                {
                  localObject5[k] = ((DynamicDiscovery.HotSearchItem)((List)localObject2).get(k)).title.get().toStringUtf8();
                  k += 1;
                }
                SharedPreUtils.a(paramQQAppInterface.getCurrentAccountUin(), (String[])localObject5);
              }
            }
            localObject4 = new BusinessSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false);
            localObject1 = localObject4;
            localObject5 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject5;
          }
        }
        if (((DynamicDiscovery.Result)localObject4).hot_search_items.get().size() < 6) {}
        for (localObject4 = null;; localObject4 = new HotWordSearchEntryDataModel(paramQQAppInterface, m, ((DynamicDiscovery.Result)localObject4).toByteArray(), paramInt, false))
        {
          if (i == 1) {
            localObject4 = null;
          }
          localObject3 = localObject4;
          localObject5 = localObject2;
          localObject2 = localObject3;
          localObject3 = localObject5;
          break;
        }
      }
      switch (i)
      {
      case 5: 
      default: 
        if (localObject1 != null) {
          localArrayList.add(localObject1);
        }
        arrayOfInt[0] = 3;
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
        arrayOfInt[1] = 1;
      }
    }
    for (;;)
    {
      boolean bool = a(arrayOfInt, SearchEntryConfigManager.a(paramQQAppInterface, paramInt, false));
      SearchEntryConfigManager.a(paramQQAppInterface, paramInt, bool, false);
      if (bool) {
        SearchEntryConfigManager.a(paramQQAppInterface, paramInt, arrayOfInt, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + localArrayList.size());
      }
      return localArrayList;
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      arrayOfInt[0] = 1;
      if (localObject3 != null) {
        localArrayList.add(localObject3);
      }
      arrayOfInt[1] = 7;
      continue;
      if (localObject3 != null) {
        localArrayList.add(localObject3);
      }
      arrayOfInt[0] = 7;
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      arrayOfInt[1] = 1;
    }
  }
  
  private static boolean a(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfInt1 == null) || (paramArrayOfInt2 == null))
    {
      bool1 = true;
      return bool1;
    }
    if (paramArrayOfInt1.length != paramArrayOfInt2.length) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramArrayOfInt1.length) {
        break;
      }
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return true;
      }
      i += 1;
    }
  }
  
  public static List<SearchEntryDataModel> b(QQAppInterface paramQQAppInterface, List<UnifySearchDiscovery.Result> paramList, int paramInt)
  {
    QLog.d("SearchEntryDataModel818searchProto_new", 2, "convertUnifyPbDataToModel");
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[paramList.size()];
    if (paramList.size() > 0)
    {
      int i = 0;
      if (i < paramList.size())
      {
        Object localObject = (UnifySearchDiscovery.Result)paramList.get(i);
        arrayOfInt[i] = ((UnifySearchDiscovery.Result)paramList.get(i)).type.get();
        int k = ((UnifySearchDiscovery.Result)localObject).type.get();
        switch (k)
        {
        case 2: 
        default: 
          localObject = null;
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((SearchEntryDataModel)localObject).b();
            localArrayList.add(localObject);
          }
          i += 1;
          break;
          List localList = ((UnifySearchDiscovery.Result)localObject).hot_search_items.get();
          if (localList.size() < 6)
          {
            localObject = null;
          }
          else
          {
            String[] arrayOfString = new String[localList.size()];
            int j = 0;
            while (j < localList.size())
            {
              arrayOfString[j] = ((UnifySearchDiscovery.HotSearchItem)localList.get(j)).title.get().toStringUtf8();
              j += 1;
            }
            SharedPreUtils.b(paramQQAppInterface.getCurrentAccountUin(), arrayOfString);
            localObject = new HotWordSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
            continue;
            localObject = new BusinessSearchEntryDataModel(paramQQAppInterface, k, ((UnifySearchDiscovery.Result)localObject).toByteArray(), paramInt, true);
          }
        }
      }
      boolean bool = a(arrayOfInt, SearchEntryConfigManager.a(paramQQAppInterface, paramInt, true));
      SearchEntryConfigManager.a(paramQQAppInterface, paramInt, bool, true);
      if (bool) {
        SearchEntryConfigManager.a(paramQQAppInterface, paramInt, arrayOfInt, true);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SearchEntryDataModel", 2, "convertPbDataToModel, modelList = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfByte = FileUtils.a(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefixpref_search_model_data" + localQQAppInterface.getCurrentAccountUin() + "_" + this.c + "_" + this.d));
        a(this.jdField_a_of_type_ArrayOfByte);
        return;
      }
      this.jdField_a_of_type_ArrayOfByte = FileUtils.a(BaseApplication.getContext().getFileStreamPath("search_discovery_sp_prefix_unifypref_search_model_data" + localQQAppInterface.getCurrentAccountUin() + "_" + this.c + "_" + this.d));
      a(this.jdField_a_of_type_ArrayOfByte);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.SearchEntryDataModel
 * JD-Core Version:    0.7.0.1
 */