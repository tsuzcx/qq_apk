import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AccountNotMatchException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class swu
  extends bapk
{
  private BaseApplicationImpl a;
  
  public swu(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static URL a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public static URL a(String paramString, int paramInt, Object paramObject)
  {
    String str;
    for (;;)
    {
      try
      {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
          return new URL(paramString);
        }
        paramObject = bhos.a(paramString);
        if (!paramObject.containsKey("busiType")) {
          continue;
        }
        paramString = paramString.replace("busiType=" + (String)paramObject.get("busiType"), "busiType=" + paramInt);
        paramString = new URL("pubaccountimage", null, paramString);
        str = paramString;
        try
        {
          if (!QLog.isColorLevel()) {
            return str;
          }
          QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
          return paramString;
        }
        catch (MalformedURLException paramObject) {}
      }
      catch (MalformedURLException paramObject)
      {
        paramString = null;
        continue;
      }
      str = paramString;
      if (!QLog.isColorLevel()) {
        return str;
      }
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramObject);
      return paramString;
      paramString = bhos.a(paramString, "busiType", paramInt + "");
    }
    return str;
  }
  
  private void a(String paramString, long paramLong)
  {
    if (bdee.b(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime(paramString)).sendAppDataIncerment(paramString, arrayOfString, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountHttpDownloader", 2, "param_PublicPlatDownloadFlow fileSize: " + paramLong);
        }
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    if (str.startsWith("pubaccountimage")) {
      str = paramDownloadParams.url.getFile();
    }
    for (;;)
    {
      Object localObject1 = bhos.a(str);
      if (((Map)localObject1).get("busiType") != null) {}
      int i;
      sww localsww;
      int j;
      Object localObject3;
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)((Map)localObject1).get("busiType"));
          paramDownloadParams.url = new URL(str);
          paramDownloadParams.urlStr = str;
          localsww = new sww(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, i);
          localsww.a(paramDownloadParams, (Map)localObject1);
          localObject1 = null;
          if (paramDownloadParams.headers == null) {
            break label642;
          }
          Header[] arrayOfHeader = paramDownloadParams.headers;
          j = arrayOfHeader.length;
          i = 0;
          if (i >= j) {
            break;
          }
          localObject3 = arrayOfHeader[i];
          if ("my_uin".equals(((Header)localObject3).getName())) {
            localObject1 = ((Header)localObject3).getValue();
          }
          i += 1;
          continue;
          i = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str + "  busiType:" + (String)((Map)localObject1).get("busiType"), localNumberFormatException);
        }
      }
      label642:
      for (Object localObject2 = localObject1;; localObject2 = null)
      {
        swv localswv = new swv(this, paramOutputStream);
        localObject1 = null;
        j = 0;
        int k = 3;
        i = k - 1;
        localObject3 = localObject1;
        if (k > 0) {
          j += 1;
        }
        label639:
        for (;;)
        {
          try
          {
            localsww.a();
            localObject3 = super.a(localswv, paramDownloadParams, localsww.a(paramURLDrawableHandler));
            localObject1 = localObject3;
            if (localObject1 != null) {
              break label639;
            }
            i = -1;
            if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
              continue;
            }
            localsww.a(j, paramDownloadParams);
            localObject3 = localObject1;
          }
          catch (IOException localIOException)
          {
            if (!localIOException.getMessage().contains(" response error! response code: ")) {
              continue;
            }
            if ((i != 0) && (!"None".equals(sww.a(localsww)))) {
              continue;
            }
            throw localIOException;
          }
          finally
          {
            if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
              continue;
            }
            localsww.a(j, paramDownloadParams);
            Object localObject4 = localObject1;
            continue;
            localsww.a(-1, localObject4.getMessage());
            continue;
            try
            {
              ((FileOutputStream)paramOutputStream).getChannel().truncate(0L);
              if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
              {
                localsww.a(j, paramDownloadParams);
                localObject4 = localObject1;
              }
            }
            catch (Exception localException)
            {
              QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str, localException);
              continue;
              if ((i == -1) || (i == 0))
              {
                localsww.a(j, paramDownloadParams);
                continue;
              }
              try
              {
                Thread.sleep(5L);
              }
              catch (InterruptedException localInterruptedException2)
              {
                localInterruptedException2.printStackTrace();
              }
            }
            continue;
            if ((i != -1) && (i != 0)) {
              continue;
            }
            localsww.a(j, paramDownloadParams);
            throw paramOutputStream;
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException paramDownloadParams)
            {
              paramDownloadParams.printStackTrace();
            }
            continue;
            if (localObject2 == null) {
              continue;
            }
            a(localObject2, localswv.a);
            return localInterruptedException2;
          }
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            throw new IOException("cancelled");
            if ((i == -1) || (i == 0))
            {
              localsww.a(j, paramDownloadParams);
              k = i;
              break;
            }
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
            }
            continue;
          }
        }
      }
    }
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof swx))
    {
      paramURLDrawableHandler = ((swx)paramURLDrawableHandler).a();
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.a(paramHttpResponse, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     swu
 * JD-Core Version:    0.7.0.1
 */