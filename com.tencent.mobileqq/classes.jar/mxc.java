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

public class mxc
  extends AsyncTask<ArrayList<mxf>, mxf, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new mxe(null);
  private String jdField_a_of_type_JavaLangString = mxc.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mxf parammxf, mxg parammxg)
  {
    try
    {
      localObject = new HttpGet(parammxf.jdField_a_of_type_JavaLangString);
      parammxg = (mxg)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammxg.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammxg = null;
        continue;
        parammxg.setHeader("Net-type", "gprs");
      }
    }
    if (parammxg != null) {
      if (bdee.h(BaseApplication.getContext()))
      {
        parammxg.setHeader("Net-type", "Wifi");
        if (parammxf.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammxg;
        }
        parammxf = parammxf.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammxf.hasNext())
        {
          localObject = (Map.Entry)parammxf.next();
          parammxg.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammxg;
  }
  
  private boolean a(mxg parammxg, HttpEntity paramHttpEntity, int paramInt)
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
          parammxg.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammxg.jdField_a_of_type_Long = paramInt;
          parammxg.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammxg.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammxg.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
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
            parammxg.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammxg.jdField_a_of_type_JavaLangString = localIOException.toString();
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
          parammxg.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammxg.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammxg.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mxf>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mxf localmxf;
    while (localIterator.hasNext())
    {
      localmxf = (mxf)localIterator.next();
      localmxf.jdField_a_of_type_Mxg = new mxg();
      localmxf.jdField_a_of_type_Mxg.jdField_a_of_type_Int = -1;
    }
    if (ec.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = ec.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localmxf = (mxf)localIterator.next();
        k = m;
        if (localmxf.jdField_b_of_type_Int != m)
        {
          k = localmxf.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmxf.c != i)
        {
          m = localmxf.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmxf.jdField_a_of_type_Int;
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
      localmxf.jdField_a_of_type_Mxg.jdField_b_of_type_Long = (l2 - l1);
      localmxf.jdField_a_of_type_Mxg.jdField_b_of_type_Int = (localmxf.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmxf.toString() + ", ";
      b(localmxf);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mxd(this, new mxf[] { localmxf })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmxf));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = bdee.g(BaseApplication.getContext());
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
  
  public void a(mxf parammxf) {}
  
  protected boolean a(HttpClient paramHttpClient, mxf parammxf)
  {
    mxg localmxg = parammxf.jdField_a_of_type_Mxg;
    localmxg.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammxf, localmxg);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmxg.jdField_a_of_type_Boolean;
      parammxf = null;
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
          paramHttpClient = parammxf;
          if (localIOException != null)
          {
            localmxg.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammxf;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammxf;
          if (localException != null)
          {
            localmxg.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammxf;
          }
        }
        parammxf = paramHttpClient.getEntity();
        if (parammxf == null)
        {
          localmxg.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammxf.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmxg.jdField_a_of_type_Int = 2;
              localmxg.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmxg.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammxf.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmxg.jdField_a_of_type_Boolean = a(localmxg, parammxf, j);
            break label192;
            localmxg.jdField_a_of_type_Int = 2;
            localmxg.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mxf parammxf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mxc
 * JD-Core Version:    0.7.0.1
 */