import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;

public class mul
  extends AsyncTask<ArrayList<mup>, mup, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new muo(null);
  private String jdField_a_of_type_JavaLangString = mul.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mup parammup, muq parammuq)
  {
    try
    {
      localObject = new HttpGet(parammup.jdField_a_of_type_JavaLangString);
      parammuq = (muq)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammuq.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammuq = null;
        continue;
        parammuq.setHeader("Net-type", "gprs");
      }
    }
    if (parammuq != null) {
      if (bbev.h(BaseApplication.getContext()))
      {
        parammuq.setHeader("Net-type", "Wifi");
        if (parammup.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammuq;
        }
        parammup = parammup.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammup.hasNext())
        {
          localObject = (Map.Entry)parammup.next();
          parammuq.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammuq;
  }
  
  private boolean a(muq parammuq, HttpEntity paramHttpEntity, int paramInt)
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
          parammuq.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammuq.jdField_a_of_type_Long = paramInt;
          parammuq.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammuq.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammuq.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
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
            parammuq.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammuq.jdField_a_of_type_JavaLangString = localIOException.toString();
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
          parammuq.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammuq.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammuq.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mup>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mup localmup;
    while (localIterator.hasNext())
    {
      localmup = (mup)localIterator.next();
      localmup.jdField_a_of_type_Muq = new muq();
      localmup.jdField_a_of_type_Muq.jdField_a_of_type_Int = -1;
    }
    if (ft.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = ft.a(false, this.jdField_a_of_type_Boolean, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localmup = (mup)localIterator.next();
        k = m;
        if (localmup.jdField_b_of_type_Int != m)
        {
          k = localmup.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmup.c != i)
        {
          m = localmup.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmup.jdField_a_of_type_Int;
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
      localmup.jdField_a_of_type_Muq.jdField_b_of_type_Long = (l2 - l1);
      localmup.jdField_a_of_type_Muq.jdField_b_of_type_Int = (localmup.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmup.toString() + ", ";
      b(localmup);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mun(this, new mup[] { localmup })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmup));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = bbev.g(BaseApplication.getContext());
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
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getConnectionManager().shutdown();
      this.jdField_a_of_type_OrgApacheHttpClientHttpClient = null;
    }
  }
  
  public void a(mup parammup) {}
  
  protected boolean a(HttpClient paramHttpClient, mup parammup)
  {
    muq localmuq = parammup.jdField_a_of_type_Muq;
    localmuq.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammup, localmuq);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmuq.jdField_a_of_type_Boolean;
      parammup = null;
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
          paramHttpClient = parammup;
          if (localIOException != null)
          {
            localmuq.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammup;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammup;
          if (localException != null)
          {
            localmuq.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammup;
          }
        }
        parammup = paramHttpClient.getEntity();
        if (parammup == null)
        {
          localmuq.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammup.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmuq.jdField_a_of_type_Int = 2;
              localmuq.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmuq.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammup.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmuq.jdField_a_of_type_Boolean = a(localmuq, parammup, j);
            break label192;
            localmuq.jdField_a_of_type_Int = 2;
            localmuq.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mup parammup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mul
 * JD-Core Version:    0.7.0.1
 */