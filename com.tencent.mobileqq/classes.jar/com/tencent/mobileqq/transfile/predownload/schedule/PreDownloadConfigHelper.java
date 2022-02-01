package com.tencent.mobileqq.transfile.predownload.schedule;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.predownload.QQPreDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PreDownloadConfigHelper
{
  private static final String TAG = "PreDownloadConfigHelper";
  @ConfigInject(configPath="Foundation/QQCommon/src/main/resources/Inject_PredownloadConfig.yml", version=1)
  private static ArrayList<Class<? extends AbsPreDownloadConfig>> mConfigClassList = new ArrayList();
  private final Map<Integer, String> mBusinessName = new HashMap();
  private final Map<Integer, String> mBusinessNameEng = new HashMap();
  private final Map<Integer, Integer> mBusinessPriority = new HashMap();
  private final ArrayList<AbsPreDownloadConfig> mConfigList = new ArrayList();
  private final List<Integer> mPreDownloadWhiteList = new ArrayList();
  private int mVersion = 0;
  
  static
  {
    mConfigClassList.add(QQPreDownloadConfig.class);
  }
  
  PreDownloadConfigHelper()
  {
    initConfigList();
    initVersion();
    initWhiteList();
    initBusinessInfo();
  }
  
  private void initBusinessInfo()
  {
    Iterator localIterator = this.mConfigList.iterator();
    while (localIterator.hasNext())
    {
      AbsPreDownloadConfig localAbsPreDownloadConfig = (AbsPreDownloadConfig)localIterator.next();
      this.mBusinessName.putAll(localAbsPreDownloadConfig.getBusinessName());
      this.mBusinessNameEng.putAll(localAbsPreDownloadConfig.getBusinessEnglishName());
      this.mBusinessPriority.putAll(localAbsPreDownloadConfig.getBusinessPriority());
    }
  }
  
  private void initConfigList()
  {
    Iterator localIterator = mConfigClassList.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      try
      {
        this.mConfigList.add(localClass.newInstance());
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadConfigHelper", 2, "initConfigList, InstantiationException ", localInstantiationException);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadConfigHelper", 2, "initConfigList, IllegalAccessException ", localIllegalAccessException);
        }
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  private void initVersion()
  {
    int i = this.mVersion;
    Iterator localIterator = this.mConfigList.iterator();
    while (localIterator.hasNext())
    {
      AbsPreDownloadConfig localAbsPreDownloadConfig = (AbsPreDownloadConfig)localIterator.next();
      if (localAbsPreDownloadConfig.getVersion() > i) {
        i = localAbsPreDownloadConfig.getVersion();
      }
    }
    this.mVersion = i;
  }
  
  private void initWhiteList()
  {
    Iterator localIterator = this.mConfigList.iterator();
    while (localIterator.hasNext())
    {
      AbsPreDownloadConfig localAbsPreDownloadConfig = (AbsPreDownloadConfig)localIterator.next();
      this.mPreDownloadWhiteList.addAll(localAbsPreDownloadConfig.getWhiteList());
    }
  }
  
  public List<String> cleanOnVersionUpdate(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(5);
    Iterator localIterator = this.mConfigList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((AbsPreDownloadConfig)localIterator.next()).cleanResOnVersionUpdate(paramInt1, paramInt2));
    }
    return localArrayList;
  }
  
  public Map<Integer, String> getBusinessName()
  {
    return this.mBusinessName;
  }
  
  public Map<Integer, String> getBusinessNameEng()
  {
    return this.mBusinessNameEng;
  }
  
  public Map<Integer, Integer> getBusinessPriority()
  {
    return this.mBusinessPriority;
  }
  
  public List<Integer> getPreDownloadWhiteList()
  {
    return this.mPreDownloadWhiteList;
  }
  
  public int getVersion()
  {
    return this.mVersion;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConfigHelper
 * JD-Core Version:    0.7.0.1
 */