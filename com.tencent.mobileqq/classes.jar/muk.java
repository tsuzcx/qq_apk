import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.download.BaseDownloadAsyncTask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;

public class muk
  extends AsyncTask<ArrayList<mun>, mun, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new mum(null);
  private String jdField_a_of_type_JavaLangString = muk.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mun parammun, muo parammuo)
  {
    try
    {
      localObject = new HttpGet(parammun.jdField_a_of_type_JavaLangString);
      parammuo = (muo)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammuo.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammuo = null;
        continue;
        parammuo.setHeader("Net-type", "gprs");
      }
    }
    if (parammuo != null) {
      if (bgnt.h(BaseApplication.getContext()))
      {
        parammuo.setHeader("Net-type", "Wifi");
        if (parammun.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammuo;
        }
        parammun = parammun.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammun.hasNext())
        {
          localObject = (Map.Entry)parammun.next();
          parammuo.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammuo;
  }
  
  private boolean a(muo parammuo, HttpEntity paramHttpEntity, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    try
    {
      paramHttpEntity = paramHttpEntity.getContent();
      if (paramHttpEntity == null)
      {
        i = 0;
        if (paramHttpEntity == null) {}
      }
    }
    catch (IOException paramHttpEntity)
    {
      try
      {
        for (;;)
        {
          paramHttpEntity.close();
          if (i != paramInt) {
            break;
          }
          bool = true;
          if (!bool) {
            break label235;
          }
          parammuo.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammuo.jdField_a_of_type_Long = paramInt;
          parammuo.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammuo.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammuo.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
          }
          paramHttpEntity = null;
        }
        byte[] arrayOfByte2 = new byte[2048];
        i = 0;
        for (;;)
        {
          try
          {
            j = paramHttpEntity.read(arrayOfByte2);
            if (j > 0) {}
          }
          catch (IOException localIOException)
          {
            parammuo.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammuo.jdField_a_of_type_JavaLangString = localIOException.toString();
            }
            int j = 0;
            continue;
            if (i + j > paramInt)
            {
              i += j;
              break;
            }
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
            i += j;
          }
        }
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          int i;
          paramHttpEntity.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label235:
          parammuo.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammuo.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammuo.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mun>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mun localmun;
    while (localIterator.hasNext())
    {
      localmun = (mun)localIterator.next();
      localmun.jdField_a_of_type_Muo = new muo();
      localmun.jdField_a_of_type_Muo.jdField_a_of_type_Int = -1;
    }
    if (eh.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = eh.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localmun = (mun)localIterator.next();
        k = m;
        if (localmun.jdField_b_of_type_Int != m)
        {
          k = localmun.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmun.c != i)
        {
          m = localmun.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmun.jdField_a_of_type_Int;
        if (!isCancelled()) {
          break;
        }
      }
      if ((QLog.isColorLevel()) && (!paramVarArgs.equals(""))) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, paramVarArgs);
      }
      return Integer.valueOf(j);
    }
    long l1 = System.currentTimeMillis();
    if (isCancelled()) {
      n = i;
    }
    label272:
    do
    {
      j += 1;
      long l2 = System.currentTimeMillis();
      localmun.jdField_a_of_type_Muo.jdField_b_of_type_Long = (l2 - l1);
      localmun.jdField_a_of_type_Muo.jdField_b_of_type_Int = (localmun.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmun.toString() + ", ";
      b(localmun);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mul(this, new mun[] { localmun })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmun));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = bgnt.g(BaseApplication.getContext());
          if (!bool) {
            break label452;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        i = n;
      }
      n = i - 1;
      if (i <= 0) {
        break label272;
      }
      break;
      label452:
      n -= 1;
    }
  }
  
  protected void a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_OrgApacheHttpClientHttpClient != null)
    {
      ThreadManager.excute(new BaseDownloadAsyncTask.1(this, this.jdField_a_of_type_OrgApacheHttpClientHttpClient), 16, null, false);
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  public void a(mun parammun) {}
  
  protected boolean a(HttpClient paramHttpClient, mun parammun)
  {
    muo localmuo = parammun.jdField_a_of_type_Muo;
    localmuo.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammun, localmuo);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmuo.jdField_a_of_type_Boolean;
      parammun = null;
      try
      {
        paramHttpClient = paramHttpClient.execute(localHttpGet);
        if (paramHttpClient == null) {
          return false;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramHttpClient = parammun;
          if (localIOException != null)
          {
            localmuo.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammun;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammun;
          if (localException != null)
          {
            localmuo.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammun;
          }
        }
        parammun = paramHttpClient.getEntity();
        if (parammun == null)
        {
          localmuo.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammun.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmuo.jdField_a_of_type_Int = 2;
              localmuo.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmuo.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammun.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmuo.jdField_a_of_type_Boolean = a(localmuo, parammun, j);
            break label192;
            localmuo.jdField_a_of_type_Int = 2;
            localmuo.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mun parammun) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     muk
 * JD-Core Version:    0.7.0.1
 */