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
import mqq.app.AccountNotMatchException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class rsl
  extends axrg
{
  private BaseApplicationImpl a;
  
  public rsl(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.a = paramBaseApplicationImpl;
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
        paramObject = befm.a(paramString);
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
      paramString = befm.a(paramString, "busiType", paramInt + "");
    }
    return str;
  }
  
  private void a(String paramString, long paramLong)
  {
    if (badq.b(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.a.getAppRuntime(paramString)).sendAppDataIncerment(paramString, arrayOfString, paramLong);
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
    label514:
    for (;;)
    {
      Object localObject1 = befm.a(str);
      if (((Map)localObject1).get("busiType") != null) {}
      int i;
      rsn localrsn;
      int j;
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)((Map)localObject1).get("busiType"));
          paramDownloadParams.url = new URL(str);
          paramDownloadParams.urlStr = str;
          localrsn = new rsn(this.a, i);
          localrsn.a(paramDownloadParams, (Map)localObject1);
          localObject1 = null;
          if (paramDownloadParams.headers == null) {
            break label554;
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
      label414:
      label551:
      label554:
      for (Object localObject3 = localObject1;; localObject3 = null)
      {
        rsm localrsm = new rsm(this, paramOutputStream);
        localObject1 = null;
        j = 0;
        int k = 3;
        i = k - 1;
        if (k > 0) {
          j += 1;
        }
        for (;;)
        {
          Object localObject2;
          try
          {
            localrsn.a();
            File localFile = super.a(localrsm, paramDownloadParams, localrsn.a(paramURLDrawableHandler));
            if (localFile != null) {
              break label551;
            }
            i = -1;
            if ((i == -1) || (i == 0))
            {
              localrsn.a(j, paramDownloadParams);
              localObject1 = localFile;
              k = i;
              break;
            }
            try
            {
              Thread.sleep(5L);
              localObject1 = localFile;
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
              localObject2 = localFile;
            }
            continue;
            label371:
            if (i != 0) {
              break label514;
            }
          }
          catch (IOException localIOException)
          {
            if (!localIOException.getMessage().contains(" response error! response code: ")) {
              break label414;
            }
            if ((i != 0) && (!"None".equals(rsn.a(localrsn)))) {
              break label428;
            }
            throw localIOException;
          }
          finally
          {
            if (i == -1) {}
          }
          localrsn.a(j, paramDownloadParams);
          for (;;)
          {
            for (;;)
            {
              throw paramOutputStream;
              localrsn.a(-1, localIOException.getMessage());
              break label371;
              try
              {
                label428:
                ((FileOutputStream)paramOutputStream).getChannel().truncate(0L);
                if ((i == -1) || (i == 0)) {
                  localrsn.a(j, paramDownloadParams);
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str, localException);
                  continue;
                  try
                  {
                    Thread.sleep(5L);
                  }
                  catch (InterruptedException localInterruptedException2)
                  {
                    localInterruptedException2.printStackTrace();
                  }
                }
              }
            }
            break;
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException paramDownloadParams)
            {
              paramDownloadParams.printStackTrace();
            }
          }
          if (localObject3 != null) {
            a((String)localObject3, localrsm.a);
          }
          return localObject2;
        }
      }
    }
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof rso))
    {
      paramURLDrawableHandler = ((rso)paramURLDrawableHandler).a();
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.a(paramHttpResponse, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsl
 * JD-Core Version:    0.7.0.1
 */