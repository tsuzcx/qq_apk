package com.tencent.mobileqq.qqlive.filter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.Gson;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraBeautyInfo;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveCameraFilterInfo;
import com.tencent.mobileqq.qqlive.filter.data.MetaMaterial;
import com.tencent.mobileqq.qqlive.filter.download.QQLiveAEResDownloader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.utils.GsonUtils;

public class QQLiveAEResManager
  extends QQLiveAEResDownloader
{
  private static volatile QQLiveAEResManager h;
  private final MutableLiveData<List<QQLiveCameraFilterInfo>> i = new MutableLiveData();
  
  public QQLiveAEResManager()
  {
    super("");
  }
  
  public static QQLiveAEResManager a()
  {
    if (h == null) {
      try
      {
        if (h == null) {
          h = new QQLiveAEResManager();
        }
      }
      finally {}
    }
    return h;
  }
  
  private List<QQLiveCameraFilterInfo> a(List<MetaMaterial> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MetaMaterial localMetaMaterial = (MetaMaterial)paramList.next();
      localArrayList.add(new QQLiveCameraFilterInfo(localMetaMaterial.b, localMetaMaterial.e, (String)localMetaMaterial.a.get("name"), localMetaMaterial.c, localMetaMaterial.d));
    }
    return localArrayList;
  }
  
  private String c(MetaMaterial paramMetaMaterial)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b(paramMetaMaterial));
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramMetaMaterial.c());
    paramMetaMaterial = ((StringBuilder)localObject).toString();
    localObject = new File(paramMetaMaterial);
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).list(new QQLiveAEResManager.5(this));
      if (localObject.length == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[getFilterPath] pngs is 0, dir:");
        ((StringBuilder)localObject).append(paramMetaMaterial);
        QLog.e("QQLiveAEResManager", 4, ((StringBuilder)localObject).toString());
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMetaMaterial);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(localObject[0]);
        return localStringBuilder.toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getFilterPath] not a directory, dir:");
      ((StringBuilder)localObject).append(paramMetaMaterial);
      QLog.e("QQLiveAEResManager", 4, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private List<MetaMaterial> c(String paramString)
  {
    return d(paramString);
  }
  
  private List<MetaMaterial> d(String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    paramString = b(paramString);
    ArrayList localArrayList2 = (ArrayList)new Gson().fromJson(paramString, new QQLiveAEResManager.2(this).getType());
    if ((!TextUtils.isEmpty(paramString)) && (localArrayList2 != null) && (!localArrayList2.isEmpty())) {
      localArrayList1.addAll(localArrayList2);
    }
    return localArrayList1;
  }
  
  private List<MetaMaterial> e()
  {
    return c("");
  }
  
  public void a(QQLiveCameraFilterInfo paramQQLiveCameraFilterInfo, @NonNull QQLiveAEResManager.QQLiveFilterLoadListener paramQQLiveFilterLoadListener)
  {
    MetaMaterial localMetaMaterial = (MetaMaterial)this.c.get(paramQQLiveCameraFilterInfo.id);
    if ((localMetaMaterial != null) && (a(localMetaMaterial)))
    {
      paramQQLiveCameraFilterInfo = c(localMetaMaterial);
      paramQQLiveFilterLoadListener.a(TextUtils.isEmpty(paramQQLiveCameraFilterInfo) ^ true, paramQQLiveCameraFilterInfo);
      return;
    }
    Object localObject = localMetaMaterial;
    if (localMetaMaterial == null)
    {
      localObject = b(this.a);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.d("QQLiveAEResManager", 4, "[ensureSetupDownloadConfig] read assets json content empty");
        paramQQLiveFilterLoadListener.a(false, null);
        return;
      }
      List localList = (List)GsonUtils.json2Obj((String)localObject, new QQLiveAEResManager.3(this).getType());
      int j = 0;
      for (;;)
      {
        localObject = localMetaMaterial;
        if (j >= localList.size()) {
          break;
        }
        if (((MetaMaterial)localList.get(j)).b.equals(paramQQLiveCameraFilterInfo.id))
        {
          localObject = (MetaMaterial)localList.get(j);
          break;
        }
        j += 1;
      }
    }
    if (localObject == null)
    {
      paramQQLiveFilterLoadListener.a(false, null);
      return;
    }
    a((MetaMaterial)localObject, new QQLiveAEResManager.4(this, (MetaMaterial)localObject, paramQQLiveFilterLoadListener));
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  public MutableLiveData<List<QQLiveCameraFilterInfo>> b()
  {
    return this.i;
  }
  
  public List<QQLiveCameraBeautyInfo> c()
  {
    return QQLiveCameraBeautyInfo.getDefaultBeauty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.filter.QQLiveAEResManager
 * JD-Core Version:    0.7.0.1
 */