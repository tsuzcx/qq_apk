import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiMapNameTask.1;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.client.HttpClient;

public class mzp
  extends AsyncTask<Void, Void, String>
{
  public GeoPoint a;
  protected HttpClient a;
  protected GeoPoint b;
  
  public mzp(PoiMapActivity paramPoiMapActivity) {}
  
  protected String a(Void... paramVarArgs)
  {
    this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = "Unknown Address";
    int i = 0;
    if (i < 3)
    {
      if ((isCancelled()) || (this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
      {
        localObject = "Unknown Address";
        label60:
        return localObject;
      }
      paramVarArgs = bdmn.a(this.jdField_a_of_type_ComTencentBizPoiMapActivity.getApplicationContext(), this.b.getLatitudeE6() / 1000000.0D, this.b.getLongitudeE6() / 1000000.0D, 3, this.jdField_a_of_type_OrgApacheHttpClientHttpClient);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a("rec_locate", "call_googlestation", "", "", "", "");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(i).append(" time: ReverseGeocode.getFromLocation, address: ");
        if (paramVarArgs != null) {
          break label187;
        }
      }
      label187:
      for (Object localObject = "";; localObject = paramVarArgs)
      {
        QLog.i("fetch_address", 2, (String)localObject);
        if (paramVarArgs != null)
        {
          localObject = paramVarArgs;
          if (paramVarArgs.length() > 0) {
            break label60;
          }
        }
        i += 1;
        break;
      }
    }
    return "Unknown Address";
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.b = paramGeoPoint;
  }
  
  protected void a(String paramString)
  {
    if ((this.b.getLatitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) || (this.b.getLongitudeE6() != this.jdField_a_of_type_ComTencentBizPoiMapActivity.i)) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (String str = "Unknown Address";; str = paramString)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.m = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.runOnUiThread(new PoiMapActivity.PoiMapNameTask.1(this, str));
      if (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint == null) {
        break;
      }
      paramString = new mzp(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      paramString.a(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = paramString;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = null;
      return;
    }
  }
  
  protected void onCancelled()
  {
    if ((this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint != null) && (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.h) && (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() == this.jdField_a_of_type_ComTencentBizPoiMapActivity.i))
    {
      mzp localmzp = new mzp(this.jdField_a_of_type_ComTencentBizPoiMapActivity);
      localmzp.a(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint);
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a = localmzp;
      this.jdField_a_of_type_ComTencentBizPoiMapActivity.a.execute(new Void[0]);
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mzp
 * JD-Core Version:    0.7.0.1
 */