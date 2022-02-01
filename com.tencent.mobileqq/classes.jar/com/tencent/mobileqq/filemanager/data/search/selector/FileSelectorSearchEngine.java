package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.IContactSearchable;
import com.tencent.mobileqq.search.ISearchable;
import com.tencent.mobileqq.search.SearchTask.SearchTaskCallBack;
import com.tencent.mobileqq.search.base.engine.ISearchEngine;
import com.tencent.mobileqq.search.base.engine.ISearchListener;
import com.tencent.mobileqq.search.base.model.SearchRequest;
import com.tencent.mobileqq.search.util.SearchUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileSelectorSearchEngine
  implements SearchTask.SearchTaskCallBack, ISearchEngine<FileSelectorSearchResultModel>
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileSelectorSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable = new FileSelectorSearchEngine.SearchRunnable(this, null);
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public FileSelectorSearchEngine(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private List<FileSelectorSearchResultModel> b(SearchRequest paramSearchRequest)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(paramSearchRequest.a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      RecentFileSearchResultModel localRecentFileSearchResultModel = new RecentFileSearchResultModel(paramSearchRequest.a, this.jdField_a_of_type_Int);
      localObject = (List)localMap.get(localObject);
      localRecentFileSearchResultModel.a(this.jdField_a_of_type_AndroidOsBundle);
      localRecentFileSearchResultModel.a((List)localObject);
      if (localRecentFileSearchResultModel.e_() > 0) {
        localArrayList.add(localRecentFileSearchResultModel);
      }
    }
    return localArrayList;
  }
  
  private List<FileSelectorSearchResultModel> c(SearchRequest paramSearchRequest)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("file_choose_extension_handle_type", -1);
    Object localObject4;
    Object localObject2;
    if (i == 1)
    {
      localObject3 = this.jdField_a_of_type_AndroidOsBundle.getString("file_choose_extension_in_filter");
      localObject4 = this.jdField_a_of_type_AndroidOsBundle.getString("file_choose_extension_out_filter");
      if (!((String)localObject3).equals(""))
      {
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (!((String)localObject3).contains(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|")) {}
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append("QQ");
        ((StringBuilder)localObject1).append("/");
        String str = ((StringBuilder)localObject1).toString();
        localObject2 = localObject3;
        localObject1 = localObject4;
        if (str != null)
        {
          ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, str, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
          localObject2 = localObject3;
          localObject1 = localObject4;
        }
      }
    }
    else
    {
      localObject2 = "";
      localObject1 = ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|";
    }
    Object localObject3 = FMSettings.a().getDefaultRecvPath();
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, (String)localObject3, (String)localObject2, (String)localObject1, localHashMap, null);
    }
    if ((i == -1) && (a()))
    {
      localObject3 = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).qureyApks(this.jdField_a_of_type_AndroidContentContext, null);
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        localHashMap.put("installedApk", localObject3);
      }
    }
    localObject3 = FMSettings.a().getOtherRecvPath();
    if (localObject3 != null) {
      ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).scanFileList(true, (String)localObject3, (String)localObject2, (String)localObject1, localHashMap, null);
    }
    Object localObject1 = new HashMap();
    if (!localHashMap.isEmpty())
    {
      localObject2 = new ArrayList();
      localObject3 = localHashMap.values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (List)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
          ((List)localObject2).addAll((Collection)localObject4);
        }
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileInfo)((Iterator)localObject2).next();
          localObject4 = ((FileInfo)localObject3).d();
          if (((String)localObject4).indexOf(paramSearchRequest.a) >= 0)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
          else if (SearchUtils.b(paramSearchRequest.a, (String)localObject4, IContactSearchable.g) > -9223372036854775808L)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
        }
      }
      if (!((Map)localObject1).isEmpty())
      {
        localObject2 = ((Map)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new LocalFileSearchResultModel(paramSearchRequest.a, this.jdField_a_of_type_Int);
          ((LocalFileSearchResultModel)localObject4).a((List)((Map)localObject1).get(localObject3));
          ((LocalFileSearchResultModel)localObject4).a(this.jdField_a_of_type_AndroidOsBundle);
          localArrayList.add(localObject4);
        }
      }
    }
    return localArrayList;
  }
  
  private List<FileSelectorSearchResultModel> d(SearchRequest paramSearchRequest)
  {
    return new ArrayList();
  }
  
  public List<FileSelectorSearchResultModel> a(SearchRequest paramSearchRequest)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 16) {
      paramSearchRequest = b(paramSearchRequest);
    } else if (i == 17) {
      paramSearchRequest = c(paramSearchRequest);
    } else if (i == 18) {
      paramSearchRequest = d(paramSearchRequest);
    } else {
      paramSearchRequest = null;
    }
    Object localObject = paramSearchRequest;
    if (paramSearchRequest == null) {
      localObject = new ArrayList();
    }
    return localObject;
  }
  
  public void a() {}
  
  public void a(int paramInt, List<? extends ISearchable> paramList) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(SearchRequest paramSearchRequest, ISearchListener<FileSelectorSearchResultModel> paramISearchListener)
  {
    if ((paramSearchRequest != null) && (paramSearchRequest.a != null))
    {
      if (TextUtils.isEmpty(paramSearchRequest.a.trim())) {
        return;
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = paramSearchRequest;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = paramISearchListener;
        ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable, 64);
        ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable);
        return;
      }
    }
  }
  
  protected boolean a()
  {
    if (this.b) {
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.b = true;
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseModelSearchRequest = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_ComTencentMobileqqSearchBaseEngineISearchListener = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine
 * JD-Core Version:    0.7.0.1
 */