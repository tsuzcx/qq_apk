package cooperation.qzone.statistic.access;

import cooperation.qzone.statistic.access.concept.Key;

public class WnsKeys
{
  public static Key APN;
  public static Key AppId;
  public static Key Build;
  public static Key BusiServerip;
  public static Key CommandId;
  public static Key DType;
  public static Key Detail;
  public static Key Device = new Key("device");
  public static Key DeviceInfo;
  public static Key DnsTime;
  public static Key Frequency;
  public static Key ODetails;
  public static Key Port;
  public static Key[] PrivateKeys;
  public static Key[] PublicKeys;
  public static Key Qua;
  public static Key ReleaseVersion;
  public static Key RequestSize;
  public static Key ResponseSize;
  public static Key ResultCode_i;
  public static Key SDKVersion = new Key("sdkversion");
  public static Key Sequence;
  public static Key ServerIP;
  public static Key TEST;
  public static Key TcpTime;
  public static Key TimeCost;
  public static Key Timestamp;
  public static Key ToUIN;
  
  static
  {
    DeviceInfo = new Key("deviceinfo");
    CommandId = new Key("commandid");
    APN = new Key("apn");
    ResultCode_i = new Key("resultcode");
    Timestamp = new Key("stime");
    ToUIN = new Key("touin");
    TimeCost = new Key("tmcost");
    RequestSize = new Key("reqsize");
    ResponseSize = new Key("rspsize");
    Frequency = new Key("frequency");
    ServerIP = new Key("serverip");
    Detail = new Key("detail");
    Sequence = new Key("seq");
    Qua = new Key("qua");
    Port = new Key("port");
    AppId = new Key("appid");
    ReleaseVersion = new Key("releaseversion");
    Build = new Key("build");
    DType = new Key("dtype");
    ODetails = new Key("odetails");
    BusiServerip = new Key("busiserverip");
    TEST = new Key("test");
    DnsTime = new Key("dnstime");
    TcpTime = new Key("tcptime");
    PublicKeys = new Key[] { Device, SDKVersion, DeviceInfo };
    PrivateKeys = new Key[] { AppId, ReleaseVersion, Build, CommandId, APN, ResultCode_i, Timestamp, ToUIN, TimeCost, RequestSize, ResponseSize, Frequency, ServerIP, Port, Detail, Sequence, Qua, DType, ODetails, TEST, DnsTime, TcpTime };
    Key.initializeOrders(PublicKeys);
    Key.initializeOrders(PrivateKeys);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.access.WnsKeys
 * JD-Core Version:    0.7.0.1
 */