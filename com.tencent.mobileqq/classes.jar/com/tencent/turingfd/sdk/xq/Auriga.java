package com.tencent.turingfd.sdk.xq;

public enum Auriga
{
  public final int value;
  
  static
  {
    Sh = new Auriga("DEVICE_ID", 1, 1);
    Th = new Auriga("IMEI", 2, 2);
    ANDROID_ID = new Auriga("ANDROID_ID", 3, 3);
    Uh = new Auriga("CID", 4, 4);
    Vh = new Auriga("SERIAL_ID", 5, 5);
    MAC = new Auriga("MAC", 6, 6);
    Wh = new Auriga("KERNEL_VERSION", 7, 7);
    FINGERPRINT = new Auriga("FINGERPRINT", 8, 8);
    Xh = new Auriga("SYS_DF", 9, 9);
    STORAGE = new Auriga("STORAGE", 10, 10);
    SENSORS = new Auriga("SENSORS", 11, 11);
    CPU_ABI = new Auriga("CPU_ABI", 12, 12);
    Yh = new Auriga("BATTERY", 13, 13);
    DISPLAY = new Auriga("DISPLAY", 14, 14);
    Zh = new Auriga("DEFAULT_RINGTONE", 15, 15);
    _h = new Auriga("FONTS", 16, 16);
    ai = new Auriga("PKG_LIST", 17, 17);
    bi = new Auriga("FILES1", 18, 18);
    ci = new Auriga("FILES2", 19, 19);
    ROOT = new Auriga("ROOT", 20, 20);
    di = new Auriga("EMULATOR", 21, 21);
    ei = new Auriga("DUAL_APP", 22, 22);
    BRAND = new Auriga("BRAND", 23, 23);
    MODEL = new Auriga("MODEL", 24, 24);
    fi = new Auriga("SYSTEM_VER", 25, 25);
    gi = new Auriga("UUID", 26, 26);
    hi = new Auriga("INODE", 27, 27);
    ii = new Auriga("TICKET_ID", 28, 28);
    ji = new Auriga("TURINGMM_UNIQUEID", 29, 29);
    ki = new Auriga("QQPIM_VID", 30, 30);
    li = new Auriga("QQPIM_GUID", 31, 31);
    mi = new Auriga("IMSI", 32, 32);
    ni = new Auriga("API_LEVEL", 33, 33);
    oi = new Auriga("DEBUG_INFO", 34, 34);
    pi = new Auriga("BOOT_TIME", 35, 35);
    qi = new Auriga("PHYSICAL_DISPLAY", 36, 36);
    ri = new Auriga("API_AVAILABILITY", 37, 37);
    si = new Auriga("WIFI_CONFIGS", 38, 38);
    ti = new Auriga("FRAMEWORK_RES", 39, 39);
    ui = new Auriga("PKG_LIST_HASH", 40, 40);
    vi = new Auriga("OAID", 41, 41);
    MANUFACTURER = new Auriga("MANUFACTURER", 42, 42);
    wi = new Auriga("PKG_LIST_2", 43, 43);
    Je = new Auriga("INJECT", 44, 100);
    xi = new Auriga("HOOK_FRAMEWORK", 45, 101);
    yi = new Auriga("SIMULATOR_LOCATION", 46, 102);
    zi = new Auriga("USB_TYPE", 47, 103);
    Ai = new Auriga("CHARGE_STATE", 48, 104);
    Ye = new Auriga("BATTERY_LEVEL", 49, 105);
    Bi = new Auriga("RISK_PROCESS", 50, 106);
    Ci = new Auriga("PKG_SIGMD5", 51, 107);
    Di = new Auriga("EMULATOR_RAW", 52, 108);
    Ei = new Auriga("LOCAL_NETWORK_MACS", 53, 109);
    Fi = new Auriga("DEVICE_SPHERICAL", 54, 110);
    Gi = new Auriga("DEVICE_ORIENTATION", 55, 111);
    Hi = new Auriga("TRACE_IP", 56, 112);
    Ii = new Auriga("VPN", 57, 113);
    PROXY = new Auriga("PROXY", 58, 114);
    Ji = new Auriga("DISABLE_FEATURE_ID", 59, 200);
    Ki = new Auriga("IOS_IDFA", 60, 1001);
    Li = new Auriga("IOS_IDFV", 61, 1002);
    Mi = new Auriga("IOS_BOOT_TIMESTAMP", 62, 1003);
    Ni = new Auriga("IOS_CURRENT_TIMESTAMP", 63, 1004);
    Oi = new Auriga("IOS_FREE_SPACE", 64, 1005);
    Pi = new Auriga("IOS_TOTAL_SPACE", 65, 1006);
    Qi = new Auriga("IOS_TOTAL_MEMORY", 66, 1007);
    Ri = new Auriga("IOS_SCREEN_BRIGHTNESS", 67, 1008);
    Si = new Auriga("IOS_WIFI_IP_ADDRESS", 68, 1009);
    Ti = new Auriga("IOS_CELLULAR_WIFI_IP_ADDRESS", 69, 1010);
    Ui = new Auriga("IOS_VPN_IP_ADDRESS", 70, 1011);
    Vi = new Auriga("IOS_MAC_ADDRESS", 71, 1012);
    Wi = new Auriga("IOS_NETWORK_TYPE", 72, 1013);
    Xi = new Auriga("IOS_ROUNTER_SSID", 73, 1014);
    Yi = new Auriga("IOS_ROUNTER_BSSID", 74, 1015);
    Zi = new Auriga("IOS_PROXY_TYPE", 75, 1016);
    _i = new Auriga("IOS_PROXY_URL", 76, 1017);
    aj = new Auriga("IOS_DNS", 77, 1018);
    bj = new Auriga("IOS_JAILBROKEN", 78, 1019);
    cj = new Auriga("IOS_IPHONE_MODEL", 79, 1020);
    dj = new Auriga("IOS_SYSTEM_VERSION", 80, 1021);
    ej = new Auriga("IOS_DEVICE_NAME", 81, 1022);
    fj = new Auriga("IOS_CARRIER", 82, 1023);
    gj = new Auriga("IOS_COUNTRY_ISO", 83, 1024);
    hj = new Auriga("IOS_MCC", 84, 1025);
    ij = new Auriga("IOS_MNC", 85, 1026);
    jj = new Auriga("IOS_BUNDLE_ID", 86, 1027);
    kj = new Auriga("IOS_LANGUAGES", 87, 1028);
    lj = new Auriga("IOS_TIMESTAMP_APP_INSTALLED", 88, 1029);
    mj = new Auriga("IOS_TIMESTAMP_LIST_FOR_ALBUM", 89, 1030);
    nj = new Auriga("IOS_AVAILABLE_SENSORS", 90, 1031);
    oj = new Auriga("IOS_RING_VOLUME", 91, 1032);
    Auriga localAuriga = TIMESTAMP;
    localAuriga = Sh;
    localAuriga = Th;
    localAuriga = ANDROID_ID;
    localAuriga = Uh;
    localAuriga = Vh;
    localAuriga = MAC;
    localAuriga = Wh;
    localAuriga = FINGERPRINT;
    localAuriga = Xh;
    localAuriga = STORAGE;
    localAuriga = SENSORS;
    localAuriga = CPU_ABI;
    localAuriga = Yh;
    localAuriga = DISPLAY;
    localAuriga = Zh;
    localAuriga = _h;
    localAuriga = ai;
    localAuriga = bi;
    localAuriga = ci;
    localAuriga = ROOT;
    localAuriga = di;
    localAuriga = ei;
    localAuriga = BRAND;
    localAuriga = MODEL;
    localAuriga = fi;
    localAuriga = gi;
    localAuriga = hi;
    localAuriga = ii;
    localAuriga = ji;
    localAuriga = ki;
    localAuriga = li;
    localAuriga = mi;
    localAuriga = ni;
    localAuriga = oi;
    localAuriga = pi;
    localAuriga = qi;
    localAuriga = ri;
    localAuriga = si;
    localAuriga = ti;
    localAuriga = ui;
    localAuriga = vi;
    localAuriga = MANUFACTURER;
    localAuriga = wi;
    localAuriga = Je;
    localAuriga = xi;
    localAuriga = yi;
    localAuriga = zi;
    localAuriga = Ai;
    localAuriga = Ye;
    localAuriga = Bi;
    localAuriga = Ci;
    localAuriga = Di;
    localAuriga = Ei;
    localAuriga = Fi;
    localAuriga = Gi;
    localAuriga = Hi;
    localAuriga = Ii;
    localAuriga = PROXY;
    localAuriga = Ji;
    localAuriga = Ki;
    localAuriga = Li;
    localAuriga = Mi;
    localAuriga = Ni;
    localAuriga = Oi;
    localAuriga = Pi;
    localAuriga = Qi;
    localAuriga = Ri;
    localAuriga = Si;
    localAuriga = Ti;
    localAuriga = Ui;
    localAuriga = Vi;
    localAuriga = Wi;
    localAuriga = Xi;
    localAuriga = Yi;
    localAuriga = Zi;
    localAuriga = _i;
    localAuriga = aj;
    localAuriga = bj;
    localAuriga = cj;
    localAuriga = dj;
    localAuriga = ej;
    localAuriga = fj;
    localAuriga = gj;
    localAuriga = hj;
    localAuriga = ij;
    localAuriga = jj;
    localAuriga = kj;
    localAuriga = lj;
    localAuriga = mj;
    localAuriga = nj;
    localAuriga = oj;
  }
  
  public Auriga(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    return name() + ":" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Auriga
 * JD-Core Version:    0.7.0.1
 */