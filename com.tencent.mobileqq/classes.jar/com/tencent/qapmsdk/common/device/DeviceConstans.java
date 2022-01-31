package com.tencent.qapmsdk.common.device;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceConstans;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceConstans
{
  @NotNull
  public static final String AVAILABLE_BLOCKDEVICES = "/sys/block/";
  @NotNull
  public static final String AVAILABLE_SCHEDULERS = "/sys/block/mmcblk0/queue/scheduler";
  @NotNull
  public static final String AVAILABLE_SCHEDULERS_PATH = "/sys/block/mmcblk1/queue/scheduler";
  private static final String CPU_FREQ_SYS_DIR = "/sys/devices/system/cpu/cpu0/cpufreq/";
  @NotNull
  public static final String CPU_INFO_CUR_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_cur_freq";
  @NotNull
  public static final String CPU_INFO_DIR = "/proc/cpuinfo";
  @NotNull
  public static final String CPU_INFO_MAX_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
  @NotNull
  public static final String CPU_INFO_MIN_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq";
  @NotNull
  public static final String CPU_SYS_DIR = "/sys/devices/system/cpu/";
  public static final DeviceConstans.Companion Companion = new DeviceConstans.Companion(null);
  @NotNull
  public static final String DEFAULT_RECIVE_WINDOW = "/proc/sys/net/core/rmem_default";
  @NotNull
  public static final String DEFAULT_SEND_WINDOW = "/proc/sys/net/core/wmem_default";
  @NotNull
  public static final String ETH_MAC_ADDRESS = "/sys/class/net/eth1/address";
  @NotNull
  public static final String IO_SCHEDULER_MTD = "/sys/block/mtdblock0/queue/scheduler";
  @NotNull
  public static final String SCALING_AVAILABLE_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_frequencies";
  @NotNull
  public static final String SCALING_AVAILABLE_GOVERNORS = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_available_governors";
  @NotNull
  public static final String SCALING_CUR_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
  @NotNull
  public static final String SCALING_GOVERNOR = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_governor";
  @NotNull
  public static final String SCALING_MAX_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_max_freq";
  @NotNull
  public static final String SCALING_MIN_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_min_freq";
  @NotNull
  public static final String TIME_IN_STATES = "/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state";
  @NotNull
  public static final String WLAN_MAC_ADDRESS = "/sys/class/net/wlan0/address";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceConstans
 * JD-Core Version:    0.7.0.1
 */