import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.download.BaseDownloadAsyncTask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class mvq
  extends AsyncTask<ArrayList<mvt>, mvt, Integer>
{
  private static final Handler jdField_a_of_type_AndroidOsHandler = new mvs(null);
  private String jdField_a_of_type_JavaLangString = mvq.class.getSimpleName();
  private HttpClient jdField_a_of_type_OrgApacheHttpClientHttpClient;
  boolean jdField_a_of_type_Boolean = false;
  
  private HttpGet a(mvt parammvt, mvu parammvu)
  {
    try
    {
      localObject = new HttpGet(parammvt.jdField_a_of_type_JavaLangString);
      parammvu = (mvu)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          parammvu.jdField_a_of_type_JavaLangString = localIllegalArgumentException.toString();
        }
        parammvu = null;
        continue;
        parammvu.setHeader("Net-type", "gprs");
      }
    }
    if (parammvu != null) {
      if (NetworkUtil.isWifiConnected(BaseApplication.getContext()))
      {
        parammvu.setHeader("Net-type", "Wifi");
        if (parammvt.jdField_a_of_type_JavaUtilHashMap == null) {
          return parammvu;
        }
        parammvt = parammvt.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        while (parammvt.hasNext())
        {
          localObject = (Map.Entry)parammvt.next();
          parammvu.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return parammvu;
  }
  
  private boolean a(mvu parammvu, HttpEntity paramHttpEntity, int paramInt)
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
          parammvu.jdField_a_of_type_ArrayOfByte = arrayOfByte1;
          parammvu.jdField_a_of_type_Long = paramInt;
          parammvu.jdField_a_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          parammvu.jdField_a_of_type_Int = 3;
          if (paramHttpEntity != null) {
            parammvu.jdField_a_of_type_JavaLangString = paramHttpEntity.toString();
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
            parammvu.jdField_a_of_type_Int = 3;
            if (localIOException != null) {
              parammvu.jdField_a_of_type_JavaLangString = localIOException.toString();
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
          parammvu.jdField_a_of_type_Int = 3;
          if (i < paramInt) {
            parammvu.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + " but read " + i);
          } else {
            parammvu.jdField_a_of_type_JavaLangString = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<mvt>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    mvt localmvt;
    while (localIterator.hasNext())
    {
      localmvt = (mvt)localIterator.next();
      localmvt.jdField_a_of_type_Mvu = new mvu();
      localmvt.jdField_a_of_type_Mvu.jdField_a_of_type_Int = -1;
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
        localmvt = (mvt)localIterator.next();
        k = m;
        if (localmvt.jdField_b_of_type_Int != m)
        {
          k = localmvt.jdField_b_of_type_Int;
          HttpConnectionParams.setConnectionTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), k);
        }
        m = i;
        if (localmvt.c != i)
        {
          m = localmvt.c;
          HttpConnectionParams.setSoTimeout(this.jdField_a_of_type_OrgApacheHttpClientHttpClient.getParams(), m);
        }
        i = localmvt.jdField_a_of_type_Int;
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
      localmvt.jdField_a_of_type_Mvu.jdField_b_of_type_Long = (l2 - l1);
      localmvt.jdField_a_of_type_Mvu.jdField_b_of_type_Int = (localmvt.jdField_a_of_type_Int - n);
      paramVarArgs = paramVarArgs + localmvt.toString() + ", ";
      b(localmvt);
      jdField_a_of_type_AndroidOsHandler.obtainMessage(1, new mvr(this, new mvt[] { localmvt })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.jdField_a_of_type_OrgApacheHttpClientHttpClient, localmvt));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = NetworkUtil.isNetworkAvailable(BaseApplication.getContext());
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
  
  public void a(mvt parammvt) {}
  
  protected boolean a(HttpClient paramHttpClient, mvt parammvt)
  {
    mvu localmvu = parammvt.jdField_a_of_type_Mvu;
    localmvu.jdField_a_of_type_Int = -2;
    HttpGet localHttpGet = a(parammvt, localmvu);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localmvu.jdField_a_of_type_Boolean;
      parammvt = null;
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
          paramHttpClient = parammvt;
          if (localIOException != null)
          {
            localmvu.jdField_a_of_type_JavaLangString = localIOException.toString();
            paramHttpClient = parammvt;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = parammvt;
          if (localException != null)
          {
            localmvu.jdField_a_of_type_JavaLangString = localException.toString();
            paramHttpClient = parammvt;
          }
        }
        parammvt = paramHttpClient.getEntity();
        if (parammvt == null)
        {
          localmvu.jdField_a_of_type_Int = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)parammvt.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localmvu.jdField_a_of_type_Int = 2;
              localmvu.jdField_a_of_type_JavaLangString = ("invalid contentLength " + j);
              label192:
              if (localmvu.jdField_a_of_type_Boolean) {
                continue;
              }
            }
          }
          try
          {
            parammvt.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localmvu.jdField_a_of_type_Boolean = a(localmvu, parammvt, j);
            break label192;
            localmvu.jdField_a_of_type_Int = 2;
            localmvu.jdField_a_of_type_JavaLangString = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(mvt parammvt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mvq
 * JD-Core Version:    0.7.0.1
 */