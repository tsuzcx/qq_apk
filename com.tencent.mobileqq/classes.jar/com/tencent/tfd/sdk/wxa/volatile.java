package com.tencent.tfd.sdk.wxa;

public enum volatile
{
  public final int value;
  
  static
  {
    Pd = new volatile("DEVICE_ID", 1, 1);
    Qd = new volatile("IMEI", 2, 2);
    ANDROID_ID = new volatile("ANDROID_ID", 3, 3);
    Rd = new volatile("CID", 4, 4);
    Sd = new volatile("SERIAL_ID", 5, 5);
    MAC = new volatile("MAC", 6, 6);
    Td = new volatile("KERNEL_VERSION", 7, 7);
    FINGERPRINT = new volatile("FINGERPRINT", 8, 8);
    Ud = new volatile("SYS_DF", 9, 9);
    STORAGE = new volatile("STORAGE", 10, 10);
    SENSORS = new volatile("SENSORS", 11, 11);
    CPU_ABI = new volatile("CPU_ABI", 12, 12);
    Vd = new volatile("BATTERY", 13, 13);
    DISPLAY = new volatile("DISPLAY", 14, 14);
    Wd = new volatile("DEFAULT_RINGTONE", 15, 15);
    Xd = new volatile("FONTS", 16, 16);
    Yd = new volatile("PKG_LIST", 17, 17);
    Zd = new volatile("FILES1", 18, 18);
    _d = new volatile("FILES2", 19, 19);
    ROOT = new volatile("ROOT", 20, 20);
    ae = new volatile("EMULATOR", 21, 21);
    be = new volatile("DUAL_APP", 22, 22);
    BRAND = new volatile("BRAND", 23, 23);
    MODEL = new volatile("MODEL", 24, 24);
    ce = new volatile("SYSTEM_VER", 25, 25);
    de = new volatile("UUID", 26, 26);
    ee = new volatile("INODE", 27, 27);
    fe = new volatile("TICKET_ID", 28, 28);
    ge = new volatile("TURINGMM_UNIQUEID", 29, 29);
    he = new volatile("QQPIM_VID", 30, 30);
    ie = new volatile("QQPIM_GUID", 31, 31);
    je = new volatile("IMSI", 32, 32);
    ke = new volatile("API_LEVEL", 33, 33);
    le = new volatile("DEBUG_INFO", 34, 34);
    me = new volatile("BOOT_TIME", 35, 35);
    ne = new volatile("PHYSICAL_DISPLAY", 36, 36);
    oe = new volatile("API_AVAILABILITY", 37, 37);
    pe = new volatile("WIFI_CONFIGS", 38, 38);
    qe = new volatile("FRAMEWORK_RES", 39, 39);
    re = new volatile("PKG_LIST_HASH", 40, 40);
    se = new volatile("OAID", 41, 41);
    MANUFACTURER = new volatile("MANUFACTURER", 42, 42);
    te = new volatile("PKG_LIST_2", 43, 43);
    ue = new volatile("TRACE_INFO", 44, 44);
    rb = new volatile("INJECT", 45, 100);
    ve = new volatile("HOOK_FRAMEWORK", 46, 101);
    we = new volatile("SIMULATOR_LOCATION", 47, 102);
    xe = new volatile("USB_TYPE", 48, 103);
    ye = new volatile("CHARGE_STATE", 49, 104);
    Gb = new volatile("BATTERY_LEVEL", 50, 105);
    ze = new volatile("RISK_PROCESS", 51, 106);
    Ae = new volatile("PKG_SIGMD5", 52, 107);
    Be = new volatile("EMULATOR_RAW", 53, 108);
    Ce = new volatile("LOCAL_NETWORK_MACS", 54, 109);
    De = new volatile("DEVICE_SPHERICAL", 55, 110);
    Ee = new volatile("DEVICE_ORIENTATION", 56, 111);
    Fe = new volatile("TRACE_IP", 57, 112);
    Ge = new volatile("VPN", 58, 113);
    PROXY = new volatile("PROXY", 59, 114);
    He = new volatile("DISABLE_FEATURE_ID", 60, 200);
    Ie = new volatile("IOS_IDFA", 61, 1001);
    Je = new volatile("IOS_IDFV", 62, 1002);
    Ke = new volatile("IOS_BOOT_TIMESTAMP", 63, 1003);
    Le = new volatile("IOS_CURRENT_TIMESTAMP", 64, 1004);
    Me = new volatile("IOS_FREE_SPACE", 65, 1005);
    Ne = new volatile("IOS_TOTAL_SPACE", 66, 1006);
    Oe = new volatile("IOS_TOTAL_MEMORY", 67, 1007);
    Pe = new volatile("IOS_SCREEN_BRIGHTNESS", 68, 1008);
    Qe = new volatile("IOS_WIFI_IP_ADDRESS", 69, 1009);
    Re = new volatile("IOS_CELLULAR_WIFI_IP_ADDRESS", 70, 1010);
    Se = new volatile("IOS_VPN_IP_ADDRESS", 71, 1011);
    Te = new volatile("IOS_MAC_ADDRESS", 72, 1012);
    Ue = new volatile("IOS_NETWORK_TYPE", 73, 1013);
    Ve = new volatile("IOS_ROUNTER_SSID", 74, 1014);
    We = new volatile("IOS_ROUNTER_BSSID", 75, 1015);
    Xe = new volatile("IOS_PROXY_TYPE", 76, 1016);
    Ye = new volatile("IOS_PROXY_URL", 77, 1017);
    Ze = new volatile("IOS_DNS", 78, 1018);
    _e = new volatile("IOS_JAILBROKEN", 79, 1019);
    af = new volatile("IOS_IPHONE_MODEL", 80, 1020);
    bf = new volatile("IOS_SYSTEM_VERSION", 81, 1021);
    cf = new volatile("IOS_DEVICE_NAME", 82, 1022);
    df = new volatile("IOS_CARRIER", 83, 1023);
    ef = new volatile("IOS_COUNTRY_ISO", 84, 1024);
    ff = new volatile("IOS_MCC", 85, 1025);
    gf = new volatile("IOS_MNC", 86, 1026);
    hf = new volatile("IOS_BUNDLE_ID", 87, 1027);
    if = new volatile("IOS_LANGUAGES", 88, 1028);
    jf = new volatile("IOS_TIMESTAMP_APP_INSTALLED", 89, 1029);
    kf = new volatile("IOS_TIMESTAMP_LIST_FOR_ALBUM", 90, 1030);
    lf = new volatile("IOS_AVAILABLE_SENSORS", 91, 1031);
    mf = new volatile("IOS_RING_VOLUME", 92, 1032);
    volatile localvolatile = TIMESTAMP;
    localvolatile = Pd;
    localvolatile = Qd;
    localvolatile = ANDROID_ID;
    localvolatile = Rd;
    localvolatile = Sd;
    localvolatile = MAC;
    localvolatile = Td;
    localvolatile = FINGERPRINT;
    localvolatile = Ud;
    localvolatile = STORAGE;
    localvolatile = SENSORS;
    localvolatile = CPU_ABI;
    localvolatile = Vd;
    localvolatile = DISPLAY;
    localvolatile = Wd;
    localvolatile = Xd;
    localvolatile = Yd;
    localvolatile = Zd;
    localvolatile = _d;
    localvolatile = ROOT;
    localvolatile = ae;
    localvolatile = be;
    localvolatile = BRAND;
    localvolatile = MODEL;
    localvolatile = ce;
    localvolatile = de;
    localvolatile = ee;
    localvolatile = fe;
    localvolatile = ge;
    localvolatile = he;
    localvolatile = ie;
    localvolatile = je;
    localvolatile = ke;
    localvolatile = le;
    localvolatile = me;
    localvolatile = ne;
    localvolatile = oe;
    localvolatile = pe;
    localvolatile = qe;
    localvolatile = re;
    localvolatile = se;
    localvolatile = MANUFACTURER;
    localvolatile = te;
    localvolatile = ue;
    localvolatile = rb;
    localvolatile = ve;
    localvolatile = we;
    localvolatile = xe;
    localvolatile = ye;
    localvolatile = Gb;
    localvolatile = ze;
    localvolatile = Ae;
    localvolatile = Be;
    localvolatile = Ce;
    localvolatile = De;
    localvolatile = Ee;
    localvolatile = Fe;
    localvolatile = Ge;
    localvolatile = PROXY;
    localvolatile = He;
    localvolatile = Ie;
    localvolatile = Je;
    localvolatile = Ke;
    localvolatile = Le;
    localvolatile = Me;
    localvolatile = Ne;
    localvolatile = Oe;
    localvolatile = Pe;
    localvolatile = Qe;
    localvolatile = Re;
    localvolatile = Se;
    localvolatile = Te;
    localvolatile = Ue;
    localvolatile = Ve;
    localvolatile = We;
    localvolatile = Xe;
    localvolatile = Ye;
    localvolatile = Ze;
    localvolatile = _e;
    localvolatile = af;
    localvolatile = bf;
    localvolatile = cf;
    localvolatile = df;
    localvolatile = ef;
    localvolatile = ff;
    localvolatile = gf;
    localvolatile = hf;
    localvolatile = if;
    localvolatile = jf;
    localvolatile = kf;
    localvolatile = lf;
    localvolatile = mf;
  }
  
  public volatile(int paramInt)
  {
    this.value = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(name());
    localStringBuilder.append(":");
    localStringBuilder.append(this.value);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.volatile
 * JD-Core Version:    0.7.0.1
 */